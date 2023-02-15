import * as React from 'react';
import {useEffect, useState} from 'react';

import Typography from '@mui/material/Typography';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TablePagination from '@mui/material/TablePagination ';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

import * as API from "../services/incidents";


export function ActiveResourcesListView() {
  const [resources, setResources] = useState([]);


  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(15);
  const [selected, setSelected] = React.useState();

  const isSelected = (name) => selected == name;

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  useEffect(() => {
    API.getActiveResources().then(setResources);
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
