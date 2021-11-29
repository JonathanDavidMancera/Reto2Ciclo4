package reto2.reto2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "productos")
public class ProductModel {
    @Id
    private String reference;
    
    private String brand;
    private String category;
    private String material;
    private String presentacion;
    private String description;
    private boolean availability;
    private double price; //double
    private int quantity;
    private String photography;

    public ProductModel() {
    }

    public ProductModel(String reference, String brand, String category, String material, String presentacion,
            String description, double price, boolean availability, int quantity, String photography) {
        this.reference = reference;
        this.brand = brand;
        this.category = category;
        this.material = material;
        this.presentacion = presentacion;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.quantity = quantity;
        this.photography = photography;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhotography() {
        return photography;
    }

    public void setPhotography(String photography) {
        this.photography = photography;
    }

}
