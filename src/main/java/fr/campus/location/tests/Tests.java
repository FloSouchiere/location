package fr.campus.location.tests;

import fr.campus.location.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Tests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testVehicles() {

        // vehicleList

        String vehicleListTest =
                "[{\"id\":1,\"brand\":\"Audi\",\"modele\":\"A1\",\"color\":\"Black\"}," +
                        "{\"id\":2,\"brand\":\"Audi\",\"modele\":\"A2\",\"color\":\"Red\"}," +
                        "{\"id\":3,\"brand\":\"Audi\",\"modele\":\"A3\",\"color\":\"Blue\"}]";
        String vehicleList = this.restTemplate.getForObject("/Vehicle", String.class);
        assertEquals(vehicleList, vehicleListTest);

        // showVehicle

        String showVehicleTest = "{\"id\":1,\"brand\":\"Audi\",\"modele\":\"A1\",\"color\":\"Black\"}";
        String showVehicle = this.restTemplate.getForObject("/Vehicle/1", String.class);
        assertEquals(showVehicle, showVehicleTest);

        // addVehicle

        Vehicle newVehicle = new Vehicle(10, "Audi", "A10", "Pink");
        this.restTemplate.postForObject("/Vehicle", newVehicle, String.class);
        String addVehicle = this.restTemplate.getForObject("/Vehicle", String.class);
        assertEquals(addVehicle, "[{\"id\":1,\"brand\":\"Audi\",\"modele\":\"A1\",\"color\":\"Black\"}," +
                "{\"id\":2,\"brand\":\"Audi\",\"modele\":\"A2\",\"color\":\"Red\"}," +
                "{\"id\":3,\"brand\":\"Audi\",\"modele\":\"A3\",\"color\":\"Blue\"}," +
                "{\"id\":10,\"brand\":\"Audi\",\"modele\":\"A10\",\"color\":\"Pink\"}]");

        // deleteVehicle

        String deleteVehicleTest =
                "[{\"id\":1,\"brand\":\"Audi\",\"modele\":\"A1\",\"color\":\"Black\"}," +
                        "{\"id\":2,\"brand\":\"Audi\",\"modele\":\"A2\",\"color\":\"Red\"}," +
                        "{\"id\":3,\"brand\":\"Audi\",\"modele\":\"A3\",\"color\":\"Blue\"}," +
                        "{\"id\":10,\"brand\":\"Audi\",\"modele\":\"A10\",\"color\":\"Pink\"}]";
        this.restTemplate.delete("/Vehicle/10", String.class);
        String deleteVehicle = this.restTemplate.getForObject("/Vehicle", String.class);
        assertEquals(deleteVehicle, deleteVehicleTest);

        // modifyVehicle

        String modifyVehicleTest =
                "[{\"id\":1,\"brand\":\"Audi\",\"modele\":\"A1\",\"color\":\"Black\"}," +
                        "{\"id\":2,\"brand\":\"Audi\",\"modele\":\"A2\",\"color\":\"Red\"}," +
                        "{\"id\":3,\"brand\":\"Audi\",\"modele\":\"A3\",\"color\":\"Blue\"}," +
                        "{\"id\":10,\"brand\":\"Audi\",\"modele\":\"A10\",\"color\":\"Pink\"}]";
        Vehicle modifyVehicle = new Vehicle(10, "Audi", "A10", "Pink");
        this.restTemplate.put("/Vehicle/9", modifyVehicle, String.class);
        String modifiedVehicle = this.restTemplate.getForObject("/Vehicle", String.class);
        assertEquals(modifiedVehicle, modifyVehicleTest);
    }
}
