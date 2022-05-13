package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myCar")
public class Car implements Vehicle {

    @Autowired
    public Tire ty;

//-----------------------------------------------//
    //Constructor Injection
    public Car(){}
    public Car(Tire ty) {
        this.ty = ty;
    }
//-----------------------------------------------//
    //Field Injection & Constructor Injection
    public void setTy(Tire ty) {
        this.ty = ty;
    }

    public Tire getTy() {
        return ty;
    }
//-----------------------------------------------//
    public void init(){
        System.out.println("I am in Init Method");
    }
    public void destroy(){
        System.out.println("I am in Destroy Method");
    }
    public void drive(){
        System.out.println("I am driving car" + ty);

    }
}
