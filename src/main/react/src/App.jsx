import * as React from "react";

import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import AppBar from '@mui/material/AppBar';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';

import NotificationsIcon from '@mui/icons-material/Notifications';
import AddAlertIcon from '@mui/icons-material/AddAlert';
import HistoryIcon from '@mui/icons-material/History';
import MinorCrashIcon from '@mui/icons-material/MinorCrash';

import {ActiveIncidentsListView} from "./components/active-incidents-list-view";
import {ClosedIncidentsListView} from "./components/closed-incidents-list-view";
import {ActiveResourcesListView} from "./components/active-resources-list-view";

import { esES } from '@mui/material/locale';
import { createTheme, ThemeProvider, useTheme } from '@mui/material/styles';

const drawerWidth = 200;

export function App() {
  const [view, setView] = React.useState("m_incidentesEnCurso");
  const isViewSelected = (v) => v === view;

  let visibleView = "";
  if ( view === "m_incidentesEnCurso" ) {
    visibleView = <ActiveIncidentsListView/>;
  } else if ( view === "m_incidentesCerrados" ) {
    visibleView = <ClosedIncidentsListView/>;
  } else if ( view == "m_recursosMovilizados" ) {
    visibleView = <ActiveResourcesListView/>;
  }

  const theme = createTheme(
    {
      palette: {
        primary: { main: '#093866' },
        secondary: { main: '#6083a7'},
      },
    },
    esES,
  );

  return (
    <>
    <ThemeProvider theme={theme}>
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
          <Box sx={{ overflow: 'auto' }}>
            <List>
              <ListItem key="m_incidentesEnCurso" disablePadding>
                <ListItemButton sx={{ py: 1.5, minHeight: 32 }} selected={isViewSelected("m_incidentesEnCurso")} onClick={() => { setView("m_incidentesEnCurso"); }}>
                  <ListItemIcon>
                    <NotificationsIcon color="primary" />
                  </ListItemIcon>
                  <ListItemText primary="Incidentes en curso" primaryTypographyProps={{ fontSize: 12, letterSpacing: 0}}/>
                </ListItemButton>
              </ListItem>
              <ListItem key="m_crearIncidente" disablePadding>
                <ListItemButton sx={{ py: 1, minHeight: 32 }}  selected={isViewSelected("m_crearIncidente")} onClick={() => { setView("m_crearIncidente"); }}>
                  <ListItemIcon>
                    <AddAlertIcon color="secondary"/>
                  </ListItemIcon>
                  <ListItemText primary="Crear un incidente" primaryTypographyProps={{ fontSize: 12, letterSpacing: 0}}/>
                </ListItemButton>
              </ListItem>            
              <ListItem key="m_recursosMovilizados" disablePadding>
                <ListItemButton sx={{ py: 1.5, minHeight: 32 }}  selected={isViewSelected("m_recursosMovilizados")} onClick={() => { setView("m_recursosMovilizados"); }}>
                  <ListItemIcon>
                    <MinorCrashIcon color="primary"/>
                  </ListItemIcon>
                  <ListItemText primary="Recursos movilizados" primaryTypographyProps={{ fontSize: 12, letterSpacing: 0}}/>
                </ListItemButton>
              </ListItem>               
              <ListItem key="m_incidentesCerrados" disablePadding>
                <ListItemButton sx={{ py: 1.5, minHeight: 32 }} selected={isViewSelected("m_incidentesCerrados")} onClick={() => { setView("m_incidentesCerrados"); }}>
                  <ListItemIcon>
                    <HistoryIcon color="primary" />
                  </ListItemIcon>
                  <ListItemText primary="Histórico de incidentes" primaryTypographyProps={{ fontSize: 12, letterSpacing: 0}}/>
                </ListItemButton>
              </ListItem>                        
            </List>
          </Box>
        </Drawer>
        <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
          <Toolbar/>
          {visibleView}
        </Box>
      </Box>
    </ThemeProvider>
    </>
  )
}
