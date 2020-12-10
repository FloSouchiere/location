package fr.campus.location.dao;

import fr.campus.location.model.Vehicle;

import java.util.List;

public interface VehicleDao {

    List<Vehicle> findAll();
    Vehicle findById(int id);
    void save(Vehicle vehicle);
    void delete(int id);
    void put(int id, Vehicle newVehicle);

}
