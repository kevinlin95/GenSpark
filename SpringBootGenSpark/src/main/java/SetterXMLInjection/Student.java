package SetterXMLInjection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Student")
public class Student {
    @Autowired
    public Address adr;
    @Autowired
    public Phone person;

    public Student() {
    }

    public Student(Address adr, Phone person) {
        this.adr = adr;
        this.person = person;
    }

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

    public void display(){
        System.out.println("Information: " + person);
    }
    }

