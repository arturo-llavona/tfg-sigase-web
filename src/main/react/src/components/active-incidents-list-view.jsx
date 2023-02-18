import {useEffect, useState} from 'react';

import Typography from '@mui/material/Typography';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableContainer from '@mui/material/TableContainer';
import TablePagination from '@mui/material/TablePagination ';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import TableCell from '@mui/material/TableCell';

import * as API from "../services/incidents";

export function ActiveIncidentsListView() {
  // Creamos el hook para que la vista se actualice cuando se modifique el listado de incidentes
  const [incidents, setIncidents] = useState([]);
  // Creamos los hook para que la vista se actualice cuando se modifique la página que se está viendo, el número
  // de filas por página, y la fila que está seleccionada.
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(15);
  const [selected, setSelected] = useState();

  // Creamos el método que devuelve si una fila está seleccionada comparando el nombre de la fila, con la que está marcada
  // como seleccionada
  const isSelected = (name) => selected == name;

  // Creamos el método para controlar cuando se intenta cambiar de página.
  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  // Creamos el método para controlar cuando se modifican el número de filas por página.
  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  useEffect(() => {
    // Se hace una petición al API para obtener los incidentes en curso.
    API.getActiveIncidents().then(setIncidents);

    // Se crea un bucle que cada 10 segundos va actualizando la lista de incidentes en curso.
    const interval = setInterval(() => {
      API.getActiveIncidents().then(setIncidents);
    }, 10000);
    return () => clearInterval(interval);
  }, []);

  return (
    <>
    <Typography variant="h6" noWrap component="div" marginBottom={2} color="primary">
      Listado de incidentes activos
    </Typography>    
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell>Fecha de creación</TableCell>
            <TableCell align="left">Nombre de incidente</TableCell>
            <TableCell align="left">Alertante</TableCell>
            <TableCell align="left">Localización del incidente</TableCell>
            <TableCell align="left">Clasificación del incidente</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {incidents != undefined && incidents.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((incidente) => {
            const isItemSelected = isSelected(incidente.idIncidente);
            return (            
                <TableRow hover={true} selected={isItemSelected} key={incidente.idIncidente} sx={{ '&:last-child td, &:last-child th': { border: 0 }}} onClick={(event) => setSelected(incidente.idIncidente)} >
                    <TableCell component="th" scope="row">{new Date(incidente.fechaCreacion).toLocaleString("es-ES")}</TableCell>
                    <TableCell align="left">{incidente.idIncidente}-{incidente.alias}</TableCell>
                    <TableCell align="left">{incidente.alertante}</TableCell>
                    <TableCell align="left">{incidente.localizacionDescripcion}</TableCell>
                    <TableCell align="left">{incidente.clasificacionIncidente.codigo} - {incidente.clasificacionIncidente.nombre}</TableCell>
                </TableRow>
          )
        })}
        </TableBody>
      </Table>
    </TableContainer>
        <TablePagination
          rowsPerPageOptions={[5, 10, 15]}
          component="div"
          count={incidents != undefined && incidents.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
      /> 
    </>   
  );
}
