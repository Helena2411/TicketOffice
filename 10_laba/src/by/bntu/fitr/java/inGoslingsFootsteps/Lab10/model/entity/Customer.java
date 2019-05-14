package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity;

import java.util.UUID;

public class Customer {

    private String name;
    private String id;
    private String email;

    public Customer()
    {
        this.name = "no name";
        this.email = "no email";
        this.id = "no id";
    }

    public Customer(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.id = UUID.randomUUID().toString();
    }

    public Customer(Customer customer)
    {
        this(customer.name,customer.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + id +", email = " + email;
    }
}
