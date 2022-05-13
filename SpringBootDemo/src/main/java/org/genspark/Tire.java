package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tire{

    public String brand;
    public int size;

//---------------------------------------------------------------//
    //Field Injection & Constructor Injections
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("This brand is getting set!");
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

//---------------------------------------------------------------//
    //Constructor Injection
    public Tire(){

    }
    public Tire(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }
//---------------------------------------------------------------//

    @Override
    public String toString() {
        return "Tire{" +
                "brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }
}
