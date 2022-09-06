package com.company;

public class Main {

    public static void main(String[] args) {
        Database database = new Database("jdbc:h2:~/IdeaProjects/h2_java/database/...", "user","");
        database.createTable("Client", "id integer, name varchar(20), age integer");

        database.insertInto("Client", "1, 'Ion Paminteanu', 27");

        System.out.println("1) " + database.select("Client", "id", "1", 3));

        database.delete("Client", "age", "27");

        database.insertClient(2, "Iohan Cretu", 32);

        System.out.println("2) " + database.select("Client", "id", "2", 3));

        database.update("client","id", "2", "1");

        System.out.println("3) " + database.select("Client", "id", "1", 3));

        database.insertClient(2, "Arina Manole", 23);
        System.out.println("Все данные :");
        database.selectAll("Client", "*", 3);
        database.close();
    }
}
