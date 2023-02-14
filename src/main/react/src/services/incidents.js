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