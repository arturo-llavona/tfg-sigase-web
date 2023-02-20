import {useEffect, useState, Fragment} from 'react';

import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';
import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import CircularProgress from '@mui/material/CircularProgress';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';

import * as API from "../services/incidents";

export function CreateIncidentView(props) {
  // Se crea el hook para controlar el listado de selección del autocomplete
  const [open, setOpen] = useState(false);
  // Se crea el hook para trabajar con el listado de clasificaciones disponibles, en el autocomplete.
  const [options, setOptions] = useState([]);
  // Se crea un hook para controlar el id de la clasificación de un incidente que se encuentra seleccioanda
  const [idClasificacionIncidente, setIdClasificacionIncidente] = useState();
  // Se crea un hook para controlar si debe mostrarse error en el campo alias.
  const [errorAlias, setErrorAlias] = useState(false);
  // Se crea un hook para controlar si debe mostrarse un error en el campo clasificación del incidente.
  const [errorClasificacionIncidente, setErrorClasificacionIncidente] = useState(false);


  // Guardamos en una variable el tipo de usuario al que pertenece el usuario logado.
  const userTypeMeta = document.querySelector('meta[name="user_type"]');
  // Comprobamos el tipo de usuario logado, para saber si el usuario puede o no añadir observaciones médicas.
  let observacionMedicaDesactivada = true;
  if ( userTypeMeta != null ) {
    let userType = userTypeMeta.getAttribute('content');
    if ( userType === "2" ) {
      observacionMedicaDesactivada = false;
    }
  }

  // Se instancian las variables necesarias para el funcionamiento del autocomplete
  const loading = open && options.length === 0;
  useEffect(() => {
    let active = true;
    if (!loading) {
      return undefined;
    }
    // Se hace la petición al API para obtener las diferentes clasificaciones para configurarlas en el autocomplete.
    API.getClasifications().then(setOptions);

    return () => {
      active = false;
    };
  }, [loading]);

  useEffect(() => {
    if (!open) {
      setOptions([]);
    }
  }, [open]);

  // Se crea la función controladora para manejar la creción de un incidente.
  const handleCreateIncident = (event) => {
    // Se previene el comportamiento por defecto del evento submit.
    event.preventDefault();


    let error = false;
    // Si no se ha introducido valor en el alias, que es un campo requerido, mostramos error.
    if ( event.target.alias.value === "" ) {
      setErrorAlias(true);
      error = true;
    } else {
      setErrorAlias(false);
    }
    // Si no se ha introducido valor en el campo de clasificación del incidente, que es un campo requerido, mostramos error.
    if ( idClasificacionIncidente === "" || idClasificacionIncidente == undefined) {
      setErrorClasificacionIncidente(true);
      error = true;
    } else {
      setErrorClasificacionIncidente(false);
    }
    // En caso de haber mostrado error, cortamos la ejecución de la función.
    if ( error ) {
      return null;
    }

    // Se crea un incidente, y se van completando sus datos basándonos en el contenido del formulario.
    const incidente = {}
    incidente.alias = event.target.alias.value != "" ?  event.target.alias.value : null;
    incidente.alertante = event.target.alertante.value != "" ?  event.target.alertante.value : null;
    incidente.localizacionDescripcion = event.target.localizacionDescripcion.value != "" ?  event.target.localizacionDescripcion.value : null;
    incidente.localizacionLongitud = event.target.localizacionLongitud.value != "" ?  event.target.localizacionLongitud.value : null;
    incidente.localizacionLatitud = event.target.localizacionLatitud.value != "" ?  event.target.localizacionLatitud.value : null;

    // En caso de que se haya seleccionado una clasificación de incidente, se añade dentro del objeto clasificacionIncidente
    // del incidente que vamos a crear.
    if ( idClasificacionIncidente != "" ) {
      incidente.clasificacionIncidente = {
        "idClasificacionIncidente": idClasificacionIncidente
      }
    }

    // Si se ha añadido una observación en el formulario, se añade al incidente que se va a crear.
    if ( event.target.observacion != null && event.target.observacion.value !== "" ) {
      let observacionDatosMedicos = event.target.observacionDatosMedicos.checked;
      incidente.observaciones = [];
      incidente.observaciones.push({'texto': event.target.observacion.value, 'datosMedicos': observacionDatosMedicos});
    }

    // Se llama al método crearIncidente del API.
    API.createIncident(incidente).then(function(data) {
      if ( data.ok ) {
        // En caso de que la creación haya resultado exitosa, se llama al método setView del padre, para mostrar la vista
        // de incidentes en curso, y además se abre el stack indicando que la inserión ha sido correcta.
        props.setView({name: "m_incidentesEnCurso"});  
        props.setOpenStack({'open': true, 'stackMessage': 'Incidente creado con éxito.', 'severity': 'success'}); 
      } else {
        // En caso de fallar la inserción, se llama a la función setOpenStack del padre para indicar que ha ocurrido un error
        // y nos mantenemos en la vista de creación de incidente.
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
              <TextField required id="alias" placeholder="Alias" variant="standard" size="small"  helperText="* Requerido" error={errorAlias}/>
            </Box>
            <Box sx={{ '& .MuiTextField-root': { m: 1, width: '40ch' } }}>
              <TextField id="alertante"  placeholder="Alertante" variant="standard" size="small" />
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
                    required
                    error={errorClasificacionIncidente}
                    helperText="* Requerido"             
                    {...params}
                    InputProps={{
                      ...params.InputProps,
                      endAdornment: (
                        <Fragment>
                          {loading ? <CircularProgress color="inherit" size={20} /> : null}
                          {params.InputProps.endAdornment}
                        </Fragment>
                      ),
                    }}
                  />
                )}
              />
            </Box>
            <Box sx={{ '& .MuiTextField-root': { m: 1, width: '40ch' } }}>
              <TextField id="observacion" placeholder="Observación" variant="standard" size="small" multiline rows={4} maxRows={4} fullWidth />
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