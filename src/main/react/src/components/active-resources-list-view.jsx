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

export function ActiveResourcesListView() {
  // Creamos el hook para que la vista se actualice cuando se modifique el listado de recursos
  const [resources, setResources] = useState([]);
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
    // Se hace una petición al API para obtener los recursos movilizados actualmente.
    API.getActiveResources().then(setResources);

    // Se crea un bucle que cada 10 segundos va actualizando la lista de recursos movilizados actualmente.
    const interval = setInterval(() => {
      API.getActiveResources().then(setResources);
    }, 10000);
    return () => clearInterval(interval);
  }, []);

  return (
    <>
    <Typography variant="h6" noWrap component="div" marginBottom={2} color="primary">
      Listado de recursos movilizados
    </Typography>    
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell>Nombre del recurso</TableCell>
            <TableCell align="left">Nombre de incidente</TableCell>
            <TableCell align="left">Estado</TableCell>
            <TableCell align="left">Fecha del estado</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {resources != undefined && resources.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((resource) => {
            const isItemSelected = isSelected(resource.idRecurso);
            return (            
                <TableRow hover={true} selected={isItemSelected} key={resource.idRecurso} sx={{ '&:last-child td, &:last-child th': { border: 0 }}} onClick={(event) => setSelected(resource.idRecurso)} >
                    <TableCell component="th" scope="row">{resource.nombre}</TableCell>
                    <TableCell align="left">{resource.idIncidente}-{resource.nombreIncidente}</TableCell>
                    <TableCell align="left">{resource.estado.nombreEstado}</TableCell>
                    <TableCell align="left">{new Date(resource.estado.fechaEstado).toLocaleString("es-ES")}</TableCell>
                </TableRow>
          )
        })}
        </TableBody>
      </Table>
    </TableContainer>
        <TablePagination
          rowsPerPageOptions={[5, 10, 15]}
          component="div"
          count={resources != undefined && resources.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
      /> 
    </>   
  );
}
