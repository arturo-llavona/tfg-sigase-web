const API_URL = "/private/rest";

export async function getActiveIncidents() {
    try {
        const response = await fetch(`${API_URL}/incidents?closed=false`);
        const data = await response.json();

        return data;
    } catch ( error ) {
        console.error(error);
    }
}

export async function getActiveResources() {
    try {
        const response = await fetch(`${API_URL}/incidents?closed=false`);        
        const data = await response.json();

        const activeResources = [];
        data.forEach(incidente => {
            if ( incidente.recursos != null && incidente.recursos.length > 0 ) {
                incidente.recursos.forEach(recurso => {
                    if ( recurso.estado != undefined && recurso.estado != null ) {
                        activeResources.push({
                            'idRecurso' : recurso.idRecurso,
                            'nombre' : recurso.nombre,
                            'estado' : recurso.estado,
                            'tipoRecurso' : recurso.tipoRecurso,
                            'idIncidente' : incidente.idIncidente,
                            'nombreIncidente' : incidente.alias
                        });
                    }
                });
            }
        });

        return activeResources;
    } catch ( error ) {
        console.error(error);
    } 
}

export async function getClosedIncidents() {
    try {
        const response = await fetch(`${API_URL}/incidents?closed=true`);
        const data = await response.json();
        return data;
    } catch ( error ) {
        console.error(error);
    }
}

export async function getIncidentByIdIncident(idIncident) {
    try {
        const response = await fetch(`${API_URL}/incidents/${idIncident}`);
        const data = await response.json();
        return data;
    } catch ( error ) {
        console.error(error);
    }    
}

export async function getClasifications() {
    try {
        //const response = await fetch(`${API_URL}/incidents/classifications`);
        //const data = await response.json();
        return [
            {
              "idClasificacionIncidente": 3,
              "codigo": "7",
              "nombre": "Intoxicaciones"
            },
            {
              "idClasificacionIncidente": 4,
              "codigo": "7.1",
              "nombre": "Intoxicación medicamentosa o por productos tóxicos"
            },
            {
              "idClasificacionIncidente": 5,
              "codigo": "7.2",
              "nombre": "Intoxicaciones por humos o gases"
            },
            {
              "idClasificacionIncidente": 6,
              "codigo": "7.1.1",
              "nombre": "Sin más datos"
            },
            {
              "idClasificacionIncidente": 7,
              "codigo": "7.1.2",
              "nombre": "Inconsciente"
            },
            {
              "idClasificacionIncidente": 8,
              "codigo": "7.1.3",
              "nombre": "Semiconsciente/Desorientado"
            },
            {
              "idClasificacionIncidente": 9,
              "codigo": "7.1.4",
              "nombre": "Consciente"
            },
            {
              "idClasificacionIncidente": 10,
              "codigo": "7.2.1",
              "nombre": "Sin más datos"
            },
            {
              "idClasificacionIncidente": 12,
              "codigo": "7.2.2",
              "nombre": "Inconsciente"
            },
            {
              "idClasificacionIncidente": 13,
              "codigo": "7.2.3",
              "nombre": "Semiconsciente/Desorientado"
            },
            {
              "idClasificacionIncidente": 14,
              "codigo": "7.2.4",
              "nombre": "Consciente"
            }
          ];
    } catch ( error ) {
        console.error(error);
        return [];
    }    
}

export async function createIncident(incident) {
    var csrfHeaderName = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
    var token = document.querySelector('meta[name="_csrf"]').getAttribute('content')
    var headers = { 'Content-Type': 'application/json' };
    headers[csrfHeaderName] = token;

    try {
        const response = await fetch(`${API_URL}/incidents`, {
            'method': 'POST',
            'body': JSON.stringify(incident),
            'headers': headers
        });
        const data = await response.json();
        return data;
    } catch ( error ) {
        console.error(error);
    }    
}