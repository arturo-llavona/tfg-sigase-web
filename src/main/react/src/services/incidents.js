const API_URL = "/private/rest";

// Método que devuelve los incidentes activos.
export async function getActiveIncidents() {
    try {
        const response = await fetch(`${API_URL}/incidents?closed=false`);
        const data = await response.json();        
        return data;
    } catch ( error ) {
        console.error(error);
    }
}

// Método que devuelve los recursos activos
export async function getActiveResources() {
    try {
        // Lo primero que se hace es consultar los incidentes activos
        const response = await fetch(`${API_URL}/incidents?closed=false`);        
        const data = await response.json();

        const activeResources = [];
        // Después recorre cada incidente, para quedarse con la información de los recursos que están movilizados en él.
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
// Método que devuelve el listado de incidentes finalizados.
export async function getClosedIncidents() {
    try {
        const response = await fetch(`${API_URL}/incidents?closed=true`);
        const data = await response.json();
        return data;
    } catch ( error ) {
        console.error(error);
    }
}

// Método que devuelve el detalle de un incidente.
export async function getIncidentByIdIncident(idIncident) {
    try {
        const response = await fetch(`${API_URL}/incidents/${idIncident}`);
        const data = await response.json();        
        return data;
    } catch ( error ) {
        console.error(error);
    }    
}

// Método que devuelve las posibles clasificaciones de un incidente.
export async function getClasifications() {
    try {
        const response = await fetch(`${API_URL}/incidents/classifications`);
        const data = await response.json();
        return data
    } catch ( error ) {
        console.error(error);
        return [];
    }    
}

// Método que crea un incidente.
export async function createIncident(incident) {
    // Como la aplicación está protegida ante ataques CSRF, al estar realizando una petición POST hace falta enviar
    // el header csrf con su token.
    const headers = {'Content-Type': 'application/json'};
    const csrfHeaderName = document.querySelector('meta[name="_csrf_header"]');
    const token = document.querySelector('meta[name="_csrf"]');
    if ( csrfHeaderName != null && token != null ) {
        headers[csrfHeaderName.getAttribute('content')] = token.getAttribute('content');
    }    

    try {
        const response = await fetch(`${API_URL}/incidents`, {
            'method': 'POST',
            'body': JSON.stringify(incident),
            'headers': headers
        });
        return response;
    } catch ( error ) {
        console.error(error);
    }    
}