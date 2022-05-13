package ConstructorXMLInjection;

import java.util.List;

public class Phone {
    private int id;
    private String name;
    private List <Phone> ph;
    private Address add;

    @Override
    public String toString() {
        return "PhoneID{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", add=" + add +
                '}';
    }
    public Phone() {
    }

    public Phone(int id, String name, Address add) {
        this.id = id;
        this.name = name;
        this.add = add;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPh() {
        return ph;
    }

    public void setPh(List<Phone> ph) {
        this.ph = ph;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }
}
