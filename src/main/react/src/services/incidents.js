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