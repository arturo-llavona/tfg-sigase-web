import * as React from 'react';
import Typography from '@mui/material/Typography';

import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import CircularProgress from '@mui/material/CircularProgress';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';


import Paper from '@mui/material/Paper';

import * as API from "../services/incidents";


export function CreateIncidentView(props) {
  const [open, setOpen] = React.useState(false);
  const [options, setOptions] = React.useState([]);
  const [idClasificacionIncidente, setIdClasificacionIncidente] = React.useState();

  var userTypeMeta = document.querySelector('meta[name="user_type"]');
  let observacionMedicaDesactivada = true;
  if ( userTypeMeta != null ) {
    let userType = userTypeMeta.getAttribute('content');
    if ( userType === "2" ) {
      observacionMedicaDesactivada = false;
    }
  }

  const loading = open && options.length === 0;

  React.useEffect(() => {
    let active = true;

    if (!loading) {
      return undefined;
    }

    API.getClasifications().then(setOptions);

    return () => {
      active = false;
    };
  }, [loading]);

  React.useEffect(() => {
    if (!open) {
      setOptions([]);
    }
  }, [open]);
  
  const handleCreateIncident = (event) => {
    event.preventDefault();

    const incidente = {}
    incidente.alias = event.target.alias.value != "" ?  event.target.alias.value : null;
    incidente.alertante = event.target.alertante.value != "" ?  event.target.alertante.value : null;
    incidente.localizacionDescripcion = event.target.localizacionDescripcion.value != "" ?  event.target.localizacionDescripcion.value : null;
    incidente.localizacionLongitud = event.target.localizacionLongitud.value != "" ?  event.target.localizacionLongitud.value : null;
    incidente.localizacionLatitud = event.target.localizacionLatitud.value != "" ?  event.target.localizacionLatitud.value : null;

    if ( idClasificacionIncidente != "" ) {
      incidente.clasificacionIncidente = {
        "idClasificacionIncidente": idClasificacionIncidente
      }
    }
    if ( event.target.observacion != null && event.target.observacion.value !== "" ) {
      let observacionDatosMedicos = event.target.observacionDatosMedicos.checked;
      incidente.observaciones = [];
      incidente.observaciones.push({'texto': event.target.observacion.value, 'datosMedicos': observacionDatosMedicos});
    }

    API.createIncident(incidente).then(function(data) {
      if ( data.ok ) {
        props.setView("m_incidentesEnCurso");  
        props.setOpenStack({'open': true, 'stackMessage': 'Incidente creado con éxito.', 'severity': 'success'}); 
      } else {
        props.setOpenStack({'open': true, 'stackMessage': 'Ha ocurrido un error creando el incidente.', 'severity': 'error'}); 
      }
    });
  };

  return (
    <>
    <Typography variant="h6" noWrap component="div" marginBottom={2} color="primary">
      Creación de nuevo incidente
    </Typography>    
    <Box
      id="formulario-alta"
      component="form"
      onSubmit={handleCreateIncident}
      sx={{
        '& .MuiTextField-root': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off">
      <Paper>
          <Box padding={3}>
            <Box sx={{ '& .MuiTextField-root': { m: 1, width: '40ch' } }}>
              <TextField required id="alias" placeholder="Alias" variant="standard" size="small" />
            </Box>
            <Box sx={{ '& .MuiTextField-root': { m: 1, width: '40ch' } }}>
              <TextField required id="alertante"  placeholder="Alertante" variant="standard" size="small" />
            </Box>
            <Box sx={{ '& .MuiTextField-root': { m: 1, width: '40ch' } }}>
              <TextField id="localizacionDescripcion" placeholder="Localización" variant="standard" size="small" />
            </Box>
            <Box sx={{ '& .MuiTextField-root': { m: 1, width: '10ch' } }}>
              <TextField id="localizacionLongitud" placeholder="Longitud" variant="standard" size="small" />
              <TextField id="localizacionLatitud" placeholder="Latitud" variant="standard" size="small" />        
            </Box>                         
            <Box sx={{ '& .MuiTextField-root': { m: 1, width: '40ch' } }}>
              <Autocomplete
                id="clasificacion"
                fullWidth 
                sx={{ width: 300 }}
                open={open}
                onOpen={() => {
                  setOpen(true);
                }}
                onClose={() => {
                  setOpen(false);
                }}
                isOptionEqualToValue={(option, value) => option.idClasificacionIncidente === value.idClasificacionIncidente}
                getOptionLabel={(option) => `${option.codigo} - ${option.nombre}`}
                onChange={(a, b) => {
                  if ( b != undefined ) {
                    setIdClasificacionIncidente(b.idClasificacionIncidente);
                  }
                }}
                options={options}
                loading={loading}
                renderInput={(params) => (
                  <TextField  
                    placeholder="Clasificación"            
                    {...params}
                    InputProps={{
                      ...params.InputProps,
                      endAdornment: (
                        <React.Fragment>
                          {loading ? <CircularProgress color="inherit" size={20} /> : null}
                          {params.InputProps.endAdornment}
                        </React.Fragment>
                      ),
                    }}
                  />
                )}
              />
            </Box>
            <Box sx={{ '& .MuiTextField-root': { m: 1, width: '40ch' } }}>
              <TextField id="observacion" placeholder="Observacion" variant="standard" size="small" multiline rows={4} maxRows={4} fullWidth />
            </Box>
            <FormControlLabel disabled={observacionMedicaDesactivada} control={<Checkbox id="observacionDatosMedicos"/>} label="Esta observación contiene datos médicos privados" />
            <div>
              <Box paddingLeft={1} paddingBottom={1} marginTop={3}>
                <Button variant='contained' type='submit'>Crear incidente</Button>
              </Box>
            </div>
          </Box>  
      </Paper>
    </Box>
    </>   
  );
}