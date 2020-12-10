package fr.campus.location.web.controller;

import fr.campus.location.dao.VehicleDao;
import fr.campus.location.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleDao vehicleDao;

    // Récupérer la liste des véhicules

    @RequestMapping(value = "/Vehicle", method = RequestMethod.GET)
    public List<Vehicle> vehicleList() {
        return vehicleDao.findAll();
    }

    // Afficher un véhicule par son Id

    @GetMapping(value = "/Vehicle/{id}")
    public Vehicle showVehicle(@PathVariable int id) {
        return vehicleDao.findById(id);
    }

    // Ajouter un véhicule par son Id

    @PostMapping(value = "/Vehicle")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleDao.save(vehicle);
    }

    // Supprimer un véhicule par son Id

    @DeleteMapping(value = "/Vehicle/{id}")
    public void deleteVehicle(@PathVariable int id) {
        vehicleDao.delete(id);
    }

    // Modifier un véhicule par son Id

    @PutMapping(value = "/Vehicle/{id}")
    public void modifyVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
        vehicleDao.put(id, vehicle);
    }
}
