package com.hexaware.testing;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import com.hexaware.dao.CrimeAnalysisServiceImpl;
import com.hexaware.entity.Incident;
import com.hexaware.myexceptions.DuplicateRecordException;
import com.hexaware.myexceptions.IncidentNumberNotFoundException;

public class CrimeAnalysisServiceImplTest {
	 
	private CrimeAnalysisServiceImpl crimeAnalysisService;

    @Before
    public void setUp() {
        crimeAnalysisService = new CrimeAnalysisServiceImpl();
    }

    @Test(expected = IncidentNumberNotFoundException.class)
    public void testUpdateIncidentStatusNotFound() throws IncidentNumberNotFoundException {
        // This test should throw IncidentNumberNotFoundException
        crimeAnalysisService.updateIncidentStatus("Closed", 59); // Assuming incident ID 999 doesn't exist
    }
    
    @Test
    public void testCreateIncident() throws DuplicateRecordException {
        // Define attributes for a sample incident
        String incidentType = "Robbery";
        String location = "Main Street";
        String description = "Armed robbery at the bank";
        String incidentDate = "2024-02-08"; // Provide a valid date value

        // Create an incident using the addIncident method
        Incident incident = new Incident(41, incidentType, incidentDate, location, description, "", 0, 0);
        crimeAnalysisService.addIncident(incident);

        // Check if incident is not null
        assertNotNull(incident);

        // Check if incident attributes match the provided attributes
        assertEquals(incidentType, incident.getIncidentType());
        assertEquals(incidentDate, incident.getIncidentDate()); // Validate date value
        assertEquals(location, incident.getLocation());
        assertEquals(description, incident.getDescription());
    }
    
}

