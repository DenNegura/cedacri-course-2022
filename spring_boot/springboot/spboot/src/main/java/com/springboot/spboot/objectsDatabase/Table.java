package com.springboot.spboot.objectsDatabase;

public class Table {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Table{" +
                "nameTable='" + name + '\'' +
                ", hashCode='" + hashCode() +'\'' +
                '}';
    }
}
