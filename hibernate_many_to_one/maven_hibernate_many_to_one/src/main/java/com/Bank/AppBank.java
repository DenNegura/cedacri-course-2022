package com.Bank;

import com.Bank.dao.CardDAO;
import com.Bank.data.Card;

import com.Bank.data.Client;
import com.Bank.dao.ClientDAO;

import com.Bank.dao.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class AppBank {
        public static void main(String[] args) {
                SessionFactory factory = null;

                try {
                        factory = new Configuration().configure().buildSessionFactory();

                        /**Класс clientDAO**/

                        DAO<Client, Integer> clientDAO = new ClientDAO(factory);

                        /**чтение данных из таблицы client**/

//                        Client result = clientDAO.read(1);
//                        System.out.println("Read : " + result);
//                        System.out.println();

                        /**добавление данных в таблицу client**/

//                        Client client = new Client();
//                        client.setName("Andrei");
//                        client.setSurname("Testemitianu");
//                        client.setDateBirth(Date.valueOf("2000-01-11"));
//                        client.setTelephone(76560012);
//                        clientDAO.create(client);

                        /**обновление данных в таблице client**/

//                        Client result = clientDAO.read(2);
//                        result.setTelephone(65004515);
//                        clientDAO.update(result);

                        /**удаление данных из таблицы client**/

//                        Client client = clientDAO.read(2);
//                        clientDAO.delete(client);

                        /**Класс cardDAO**/

                        DAO<Card, Integer> cardDao = new CardDAO(factory);

                        /** чтение данных из таблицы bank_card **/

//                        Card result = cardDao.read(1);
//                        System.out.println("Read : " + result);

                        /** добавление данных в таблицу bank_card и client**/

//                        Card newCard = new Card();
//                        newCard.setType("diamond");
//                        newCard.setDateIssue(Date.valueOf("2022-01-23"));
//                        Client client = new Client();
//                        client.setName("Aurel");
//                        client.setSurname("Gonga");
//                        client.setDateBirth(Date.valueOf("1987-11-01"));
//                        client.setTelephone(60045103);
//                        newCard.setClient(client);
//                        System.out.println(newCard);
//                        cardDao.create(newCard);

                        /** добавление данных только в таблицу bank_card**/

//                        Card newCard = new Card();
//                        newCard.setType("gold");
//                        newCard.setDateIssue(Date.valueOf("2021-01-23"));
//                        Client client = clientDAO.read(2);
//                        newCard.setClient(client);
//                        cardDao.create(newCard);

                        /** обновление данных в таблице bank_card и client**/

//                        Card result = cardDao.read(2);
//                        System.out.println("Read : " + result);
//                        result.setType("business");
//                        result.getClient().setTelephone(78005405);
//                        cardDao.update(result);
//                        System.out.println("Update : " + cardDao.read(2));

//                        /**удаление данных таблицы bank_card**/
//
                        Card result = cardDao.read(2);
                        System.out.println("Read : " + result);
                        cardDao.delete(result);

                } finally {
                        if (factory != null) {
                                factory.close();
                        }
                }
        }
}
