package com.Bank.data;

import java.sql.*;

public class Client {

    private int idClient;
    private String name;
    private String surname;
    private Date dateBirth;
    private int telephone;
    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateBirth=" + dateBirth +
                ", telephone=" + telephone +
                '}';
    }
    public int getIdClient() {
        return idClient;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Date getDateBirth() {
        return dateBirth;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}


