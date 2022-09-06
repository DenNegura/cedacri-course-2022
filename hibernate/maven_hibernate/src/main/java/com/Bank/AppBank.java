package com.Bank;

import com.Bank.data.Client;
import com.Bank.dao.DAO;
import com.Bank.dao.ClientDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class AppBank {
        public static void main(String[] args) {
                SessionFactory factory = null;

                try {
                        factory = new Configuration().configure().buildSessionFactory();
                        DAO<Client, Integer> clientDAO = new ClientDAO(factory);

                        /**Ввод нового пользователя в таблицу**/

//                        Client client = new Client(); // создаю нового клиента
//                        client.setIdClient(2);
//                        client.setName("Andrei");
//                        client.setSurname("Testemitianu");
//                        client.setDateBirth(Date.valueOf("2022-01-11"));
//                        client.setTelephone(76560012);
//                        clientDAO.create(client);

                        /**Чтение из БД пользователя по id**/
//                        Client result = clientDAO.read(2);
//                        System.out.println("Read : " + result);
//                        System.out.println();

                        /**Обновление данных о пользователе**/
//                        Client result = clientDAO.read(2);
//                        result.setTelephone(65004515);
//                        clientDAO.update(result);
//                        result = clientDAO.read(2);
//                        System.out.println("Read : " + result);
//                        System.out.println();

                        /**Удаление клиента из таблицы**/
                        Client client = clientDAO.read(2);
                        clientDAO.delete(client);
                        System.out.println("Deleted : " + clientDAO.read(2));

                } finally {
                        if (factory != null) {
                                factory.close();
                        }
                }
        }
}
