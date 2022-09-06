package org.company.database;

public class Employee {

    private int idEmp;
    private String name;
    private String surname;
    private String email;
    private int salary;
    @Override
    public String toString() {
        return "Client{" +
                "idEmp=" + idEmp +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateBirth=" + email +
                ", salary=" + salary +
                '}';
    }
    public int getIdEmp() {
        return idEmp;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public int getSalary() {
        return salary;
    }
    public void setIdEmp(int idClient) {
        this.idEmp = idClient;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSalary(int telephone) {
        this.salary = telephone;
    }
}
