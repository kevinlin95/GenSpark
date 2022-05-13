package ConstructorXMLInjection;


public class Student {
    public Address adr;

    public Address getAdr() {
        return adr;
    }

    public void setAdr(Address adr) {
        this.adr = adr;
    }

    public Phone getPerson() {
        return person;
    }

    public void setPerson(Phone person) {
        this.person = person;
    }
    public Phone person;

    public Student() {
    }

    public Student(Address adr, Phone person) {
        this.adr = adr;
        this.person = person;
    }

    public void display(){
        System.out.println("Information: " + person);
    }
    public void destroy(){
        System.out.println("I am in Destroy Method");
    }
}
