package org.genspark;


public class Car implements Vehicle {
    private Tire ty;

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
