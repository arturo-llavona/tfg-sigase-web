import {useEffect, useState} from 'react';

import Grid from '@mui/material/Grid';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableContainer from '@mui/material/TableContainer';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';

import * as API from "../services/incidents";
import { Divider } from '@mui/material';

export function IncidentDetailView(props) {
  const idIncidente = props.idIncidente;
  // Creamos el hook para que la vista se actualice cuando se modifique el listado de incidentes
  const [incidente, setIncidente] = useState([]);

  // Creamos el hook para actualizar la vista
  useEffect(() => {
    // Se hace una petición al API para obtener el detalle del incidente
    API.getIncidentByIdIncident(idIncidente).then(setIncidente);

  }, []);

  let personaAfectadaView = "";
  if ( incidente.personaAfectada != null ) {
    personaAfectadaView = <PersonaAfectadaView data={incidente.personaAfectada}/>;
  }
  let observacionesView = "";
  if ( incidente.observaciones != null && incidente.observaciones.length > 0 ) {
    observacionesView = <ObservacionesView data={incidente.observaciones}/>;
  }
  let recursosView = "";
  if ( incidente.recursos != null && incidente.recursos.length > 0 ) {
    recursosView = <RecursosView data={incidente.recursos}/>;
  }

  return (
    <>
      <Typography variant="h6" noWrap component="div" marginBottom={2} color="primary">
        Detalle del incidente #{incidente.idIncidente}-{incidente.alias}
      </Typography>

      <Paper>
        <Box paddingTop={3} paddingLeft={3} paddingRight={3}>
          <Typography variant="body1" component="div" fontWeight={"bold"} color="primary">Información principal</Typography>
          <Grid container padding={3} rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
            <Grid xs={6}>
              <Box marginBottom={2}>
                <Typography variant="body2" component="div" fontWeight={"bold"}>Fecha de creación</Typography>
                <Typography variant="body2" component="span">{new Date(incidente.fechaCreacion).toLocaleString("es-ES")}</Typography> 
              </Box>  
            </Grid>
            <Grid xs={6}>
              <Box>
                <Typography variant="body2" component="div" fontWeight={"bold"}>Alertante</Typography>
                <Typography variant="body2" component="span">{incidente.alertante}</Typography> 
              </Box> 
            </Grid>
            <Grid xs={6}>
              <Box>
                <Typography variant="body2" component="div" fontWeight={"bold"}>Localización</Typography>
                <Typography variant="body2" component="span">{incidente.localizacionDescripcion}</Typography>
                <Typography variant="caption" component="span" marginBottom={2} color="primary"> {incidente.localizacionLongitud != null && incidente.localizacionLatitud != null ? `(${incidente.localizacionLongitud}, ${incidente.localizacionLatitud})` : ""}</Typography>          
              </Box> 
            </Grid>
            <Grid xs={6}>
              <Box>
                <Typography variant="body2" component="div" fontWeight={"bold"}>Clasificación</Typography>
                <Typography variant="body2" component="span">{incidente.clasificacionIncidente != null ? incidente.clasificacionIncidente.codigo : "" } {incidente.clasificacionIncidente != null ? incidente.clasificacionIncidente.nombre : ""}</Typography> 
              </Box>  
            </Grid>
          </Grid>   
        </Box>
      </Paper>   
      {personaAfectadaView}
      {observacionesView}
      {recursosView}
    </>   
  );
}
export function RecursosView(props) {
  const recursos = props.data;
  return (
  <>
  <Box marginTop={2}></Box>  
    <Paper>
      <Box padding={3}>      
        <Typography variant="body1" component="div" fontWeight={"bold"} color="primary">Recursos asignados a la incidencia</Typography>  
        <Box marginTop={2}></Box>
        <TableContainer component={Box}>
          <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
            <TableHead>
              <TableRow>
                <TableCell>Nombre del recurso</TableCell>
                <TableCell align="left">Tipo de recurso</TableCell>
                <TableCell align="left">Estado</TableCell>
                <TableCell align="left">Fecha del estado</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
          {recursos.map((recurso) => {
            return (
              <>
                <TableRow key={recurso.idRecurso} sx={{ '&:last-child td, &:last-child th': { border: 0 }}} >
                  <TableCell component="th" scope="row">{recurso.nombre}</TableCell>
                  <TableCell align="left">{recurso.tipoRecurso.nombre}</TableCell>
                  <TableCell align="left">{recurso.estado.nombreEstado}</TableCell>
                  <TableCell align="left">{new Date(recurso.estado.fechaEstado).toLocaleString("es-ES")}</TableCell>
                </TableRow>
              </>
            )
          })}
            </TableBody>
          </Table>
        </TableContainer>  
      </Box>
    </Paper> 
  </>
  )  
}
export function ObservacionesView(props) {
  const observaciones = props.data;
  return (
    <>  
    <Box marginTop={2}></Box>  
    <Paper>
      <Box padding={3}>      
        <Typography variant="body1" component="div" fontWeight={"bold"} color="primary">Observaciones</Typography>
        <Box marginTop={2}></Box>
        <TableContainer component={Box}>
          <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
            <TableHead>
              <TableRow>
                <TableCell>Texto</TableCell>
                <TableCell align="left">Autor</TableCell>
                <TableCell align="left">Fecha del estado</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
          {observaciones.map((observacion) => {
            return (
              <>
                <TableRow key={observacion.idObservacion} sx={{ '&:last-child td, &:last-child th': { border: 0 }}} >
                  <TableCell component="th" scope="row">{observacion.texto}</TableCell>
                  <TableCell align="left">{observacion.usuario.nombre} {observacion.usuario.apellido1} {observacion.usuario.apellido2}</TableCell>
                  <TableCell align="left">{new Date(observacion.fecha).toLocaleString("es-ES")}</TableCell>
                </TableRow>
              </>
            )
          })}
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
    </Paper>
    </>
  )
}
export function PersonaAfectadaView(props) {
  const data = props.data;
  return (
  <>
    <Box marginTop={2}></Box>
    <Paper>
      <Box paddingTop={3} paddingLeft={3} paddingRight={3}>
        <Typography variant="body1" component="div" fontWeight={"bold"} color="primary">Información de la persona afectada</Typography>  
        <Grid container padding={3} rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
          <Grid xs={6}>
            <Box marginBottom={2}>
              <Typography variant="body2" component="div" fontWeight={"bold"}>Nombre</Typography> 
              <Typography variant="body2" component="span">{data.nombre} {data.apellidos}</Typography> 
            </Box>  
          </Grid>

          <Grid xs={6}>
            <Box marginBottom={2}>
              <Typography variant="body2" component="div" fontWeight={"bold"}>Documento de identidad</Typography>
              <Typography variant="body2" component="span">{data.dni != null ? data.dni.toUpperCase() : "No indicado"}</Typography>
            </Box>  
          </Grid>
          <Grid xs={6}>
            <Box marginBottom={2}>
              <Typography variant="body2" component="div" fontWeight={"bold"}>Teléfono</Typography>
              <Typography variant="body2" component="span">{data.telefono != null ? data.telefono : "No indicado"}</Typography>  
            </Box>  
          </Grid>
          <Grid xs={6}>
            <Box marginBottom={2}>
              <Typography variant="body2" component="div" fontWeight={"bold"}>Fecha de nacimiento</Typography>
              <Typography variant="body2" component="span">{data.fechaNacimiento != null ? new Date(data.fechaNacimiento).toLocaleDateString("es-ES") : "No indicada"}</Typography>
            </Box>  
          </Grid>
          <Grid xs={6}>
            <Box marginBottom={2}>
              <Typography variant="body2" component="div" fontWeight={"bold"}>Edad</Typography>
              <Typography variant="body2" component="span">{data.edad != null ? data.edad : 'No indicada'} { (data.edad != null && data.tipoEdad != null) ? (data.tipoEdad == 1 ? 'años' : 'meses') : ''}</Typography>
            </Box>  
          </Grid>
          <Grid xs={6}>
            <Box marginBottom={2}>
              <Typography variant="body2" component="div" fontWeight={"bold"}>Sexo</Typography>
              <Typography variant="body2" component="span">{data.sexo != null ? (data.sexo == 1 ? "Hombre" : data.sexo == 2 ? "Mujer" : "Otro") : "No indicado"}</Typography>
            </Box>  
          </Grid>
          <Grid xs={6}>
            <Box marginBottom={2}>
              <Typography variant="body2" component="div" fontWeight={"bold"}>Centro de salud</Typography>
              <Typography variant="body2" component="span">{data.centroSalud != null ? data.centroSalud : "No indicado"}</Typography>
            </Box>  
          </Grid>
          <Grid xs={6}>
            <Box marginBottom={2}>
              <Typography variant="body2" component="div" fontWeight={"bold"}>Número de tarjeta sanitaria</Typography>
              <Typography variant="body2" component="span">{data.tarjetaSanitaria != null ? data.tarjetaSanitaria : "No indicado"}</Typography>
            </Box>  
          </Grid>                                                                      
        </Grid>
      </Box>
    </Paper>
  </>)
}