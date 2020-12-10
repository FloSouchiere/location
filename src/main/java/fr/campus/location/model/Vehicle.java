package fr.campus.location.model;

public class Vehicle {

    private int id;
    private String brand;
    private String modele;
    private String color;

    public Vehicle(int id, String brand, String modele, String color) {
        this.id = id;
        this.brand = brand;
        this.modele = modele;
        this.color = color;
    }
    // ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Brand

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Modele

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    // Color

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modele='" + modele + '\'' +
                ", color=" + color + '}';
    }
}

