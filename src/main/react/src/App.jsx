import * as React from "react";

import { useState, useEffect } from "react";

import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import AppBar from '@mui/material/AppBar';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Avatar from '@mui/material/Avatar';
import Link from '@mui/material/Link';

import HomeIcon from '@mui/icons-material/Home';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import LogoutIcon from '@mui/icons-material/Logout';

import { ActiveIncidentsListView } from "./components/active-incidents-list-view";
import { ClosedIncidentsListView } from "./components/closed-incidents-list-view";

import { Center } from "@chakra-ui/react";

const drawerWidth = 200;

export function App() {
  const [view, setView] = React.useState(1);
  const isViewSelected = (v) => v === view;

  let visibleView = "";
  if ( view === 1 ) {
    visibleView = <ActiveIncidentsListView></ActiveIncidentsListView>;
  } else if ( view === 2 ) {
    visibleView = <ClosedIncidentsListView></ClosedIncidentsListView>;
  }

  return (
    <>
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar position="fixed" sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}>
        <Toolbar>
          <Typography variant="h6" noWrap component="div">
            SIGASE
          </Typography>
          <Typography noWrap component="div" sx={{ fontSize: 10, marginTop: 1, paddingLeft: 1}}>
            v1.0
          </Typography>          
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box'},
        }}
      >
        <Toolbar />
        <Center>
          <Box marginTop={3} marginBottom={2}>
            <Avatar src="/broken-image.jpg" />
          </Box>
        </Center>
        <Center>
          <Box>
            <Typography variant="h7" noWrap component="div" fontSize={11} marginTop={1} fontWeight="bold" color="#3d3e42">
              Arturo Llavona Vallina
            </Typography>                              
          </Box>            
        </Center>
        <Center>
            <Box marginBottom={1} >
              <Link fontSize={9} component="button" variant="body2" onClick={() => { console.info("I'm a button."); }}>
                Cerrar sesión
              </Link> 
            </Box>
        </Center>
        <Divider />          
        <Box sx={{ overflow: 'auto' }}>
          <List>
            <ListItem key="m_incidentesEnCurso" disablePadding>
              <ListItemButton sx={{ py: 1.5, minHeight: 32 }} selected={isViewSelected(1)} onClick={() => { setView(1); }}>
                <ListItemIcon>
                  <HomeIcon color="primary" />
                </ListItemIcon>
                <ListItemText primary="Incidentes en curso" primaryTypographyProps={{ fontSize: 12, letterSpacing: 0}}/>
              </ListItemButton>
            </ListItem>
            <ListItem key="m_incidentesCerrados" disablePadding>
              <ListItemButton sx={{ py: 1.5, minHeight: 32 }} selected={isViewSelected(2)} onClick={() => { setView(2); }}>
                <ListItemIcon>
                  <HomeIcon color="primary" />
                </ListItemIcon>
                <ListItemText primary="Incidentes cerrados" primaryTypographyProps={{ fontSize: 12, letterSpacing: 0}}/>
              </ListItemButton>
            </ListItem>               
            <ListItem key="m_crearIncidente" disablePadding>
              <ListItemButton sx={{ py: 1.5, minHeight: 32 }}  selected={isViewSelected(3)} onClick={() => { setView(3); }}>
                <ListItemIcon>
                  <AddCircleIcon/>
                </ListItemIcon>
                <ListItemText primary="Crear un incidente" primaryTypographyProps={{ fontSize: 12, letterSpacing: 0}}/>
              </ListItemButton>
            </ListItem>                                       
          </List>
        </Box>
      </Drawer>
      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <Toolbar />
        {visibleView}
      </Box>
    </Box>
    </>
  )
}
