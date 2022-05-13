package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;

public class Bike implements Vehicle{
    @Autowired
    public Tire ty;
    @Override
    public void drive() {
        System.out.println("I am riding Bike.." +  ty);
    }

    public Tire getTy() {
        return ty;
    }

    public void setTy(Tire ty) {
        this.ty = ty;
    }
}
