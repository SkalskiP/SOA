package theater.dto;

import java.io.Serializable;
import java.util.UUID;

public class CustomerDTO implements Serializable {
    private String id;
    private String name;
    private String surname;
    private Integer balance;

    public CustomerDTO(String name, String surname, Integer balance) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
