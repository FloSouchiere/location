package fr.campus.location.dao;

import fr.campus.location.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {

    public static List<Vehicle> vehicles = new ArrayList<>();

    static {

        vehicles.add(new Vehicle(1, "Audi", "A1", "Black"));
        vehicles.add(new Vehicle(2, "Audi", "A2", "Red"));
        vehicles.add(new Vehicle(3, "Audi", "A3", "Blue"));
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public Vehicle findById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public void delete(int id) {
        vehicles.remove(id - 1);
    }

    @Override

    public void put(int id, Vehicle newVehicle) {
        int index = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                vehicles.set(index, newVehicle);
            }
            index += 1;
        }
    }
}