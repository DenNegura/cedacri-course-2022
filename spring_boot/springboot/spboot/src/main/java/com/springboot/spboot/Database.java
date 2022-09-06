package com.springboot.spboot;

import com.springboot.spboot.objectsDatabase.Table;

public class Database {
    private Table table;
    private String name;
    Database(){}
    Database(Table table) {
        this.table = table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Database{" +
                "table=" + table +
                ", name='" + name + '\'' +
                ", hashCode='" + hashCode() +'\'' +
                '}';
    }
}
