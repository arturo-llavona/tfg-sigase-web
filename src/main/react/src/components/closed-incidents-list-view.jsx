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
import Tooltip from '@mui/material/Tooltip';
import ManageSearchIcon from '@mui/icons-material/ManageSearch';

import * as API from "../services/incidents";

export function ClosedIncidentsListView(props) {
  // Creamos el hook para que la vista se actualice cuando se modifique el listado de incidentes
  const [incidents, setIncidents] = useState([]);
  // Creamos los hook para que la vista se actualice cuando se modifique la página que se está viendo, el número
  // de filas por página, y la fila que está seleccionada.
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(15);
  const [selected, setSelected] = useState([]);

  // Creamos el método que devuelve si una fila está seleccionada comparando el nombre de la fila, con la que está marcada
  // como seleccionada
  const isSelected = (name) => selected == name;

  // Enviamos a la vista de detalle del incidente
  const handleOpenDetail = (event, idIncidente) => {
    props.setView({name: 'm_detalleIncidente', idIncidente: idIncidente});    
  };

  // Creamos el método para controlar cuando se intenta cambiar de página.
  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  // Creamos el método para controlar cuando se modifican el número de filas por página.
  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  // Creamos el hook para actualizar la vista
  useEffect(() => {
    // Se hace una petición al API para obtener los incidentes finalizados
    API.getClosedIncidents().then(setIncidents);
  }, []);

  return (
    <>
    <Typography variant="h6" noWrap component="div" marginBottom={2} color="primary">
      Listado de incidentes finalizados
    </Typography>     
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell>Fecha de creación</TableCell>
            <TableCell>Fecha de cierre</TableCell>
            <TableCell align="left">Nombre de incidente</TableCell>
            <TableCell align="left">Alertante</TableCell>
            <TableCell align="left">Localización del incidente</TableCell>
            <TableCell align="left">Clasificación del incidente</TableCell>
            <TableCell align="center">Acciones</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {incidents != undefined && incidents.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((incidente) => {
            const isItemSelected = isSelected(incidente.idIncidente);
            return (            
                <TableRow hover={true} selected={isItemSelected} key={incidente.idIncidente} sx={{ '&:last-child td, &:last-child th': { border: 0 }}} onClick={(event) => setSelected(incidente.idIncidente)} >
                    <TableCell component="th" scope="row">{new Date(incidente.fechaCreacion).toLocaleString("es-ES")}</TableCell>
                    <TableCell component="th" scope="row">{new Date(incidente.fechaFinalizacion).toLocaleString("es-ES")}</TableCell>
                    <TableCell align="left">{incidente.idIncidente}-{incidente.alias}</TableCell>
                    <TableCell align="left">{incidente.alertante}</TableCell>
                    <TableCell align="left">{incidente.localizacionDescripcion}</TableCell>
                    <TableCell align="left">{incidente.clasificacionIncidente.codigo} - {incidente.clasificacionIncidente.nombre}</TableCell>
                    <TableCell align="center">
                      <Tooltip title="Detalle del incidente">
                        <ManageSearchIcon onClick={(event) => { handleOpenDetail(event, incidente.idIncidente);} }/>
                      </Tooltip>
                    </TableCell>                    
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
