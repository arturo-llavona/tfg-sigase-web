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


export function ActiveIncidentsListView() {
  const [incidents, setIncidents] = useState([]);

  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(20);
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
    API.getActiveIncidents().then(setIncidents);
    const interval = setInterval(() => {
      API.getActiveIncidents().then(setIncidents);
    }, 10000);
    return () => clearInterval(interval);
  }, []);

  return (
    <>
    <Typography variant="h6" noWrap component="div" marginBottom={2}>
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
          rowsPerPageOptions={[5, 10, 25]}
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
