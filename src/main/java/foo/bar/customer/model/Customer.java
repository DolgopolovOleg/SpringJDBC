package foo.bar.customer.model;

import java.sql.Timestamp;

public class Customer {

    int customID;
    String name;
    int age;

    public Customer(int id, String name, int age){
        this.customID = id;
        this.name = name;
        this.age = age;
    }

    public Customer( String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getCustomID() {
        return customID;
    }

    public void setCustomID(int customID) {
        this.customID = customID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return this.name + " " + this.age;
    }

}
