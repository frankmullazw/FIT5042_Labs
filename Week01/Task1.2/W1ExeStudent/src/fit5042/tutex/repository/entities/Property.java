/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

/**
 *
 * @author Jian
 * 
 */
public class Property {
   //TODO Exercise 1.3 Step 1 Please refer tutorial exercise.
    
    /**
     * uniquely identifies a property in the system
     */
    private int id;
    
    private String address;
    
    private int size;
    
    private double price;

    public Property(int id, String address, int size, double price) {
        this.id = id;
        this.address = address;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
//        return "Property{" + "id=" + id + ", address=" + address + ", size=" + size + ", price=" + price + '}';
        // Making use of String format to make the output neat
        return String.format("%d %s %d.0sqm $%,.2f", this.id, this.address, this.size, this.price);
    }
        
}
