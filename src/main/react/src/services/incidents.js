const API_URL = "http://localhost:8080/tfg-sigase-api/v1";

export async function getActiveIncidents() {
    try {
        const response = await fetch(`${API_URL}/incidents`, { headers: { 'USER-NAME': '71661919Z'}});
        const data = await response.json();
        return data;
    } catch ( error ) {
        console.error(error);
    }
}

export async function getClosedIncidents() {
    try {
        const response = await fetch(`${API_URL}/incidents?closed=true`, { headers: { 'USER-NAME': '71661919Z'}});
        const data = await response.json();
        return data;
    } catch ( error ) {
        console.error(error);
    }
}

export async function getIncidentByIdIncident(idIncident) {
    try {
        const response = await fetch(`${API_URL}/incidents/${idIncident}`, { headers: { 'USER-NAME': '71661919Z'}});
        const data = await response.json();
        return data;
    } catch ( error ) {
        console.error(error);
    }    
}