package com.Bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.Bank.data.Client;

public class ClientDAO implements DAO<Client,Integer>{
    private final SessionFactory factory;

    public ClientDAO(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(final Client client) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public Client read(final Integer idClient) {
        try (final Session session = factory.openSession()) {
            final Client result = session.get(Client.class, idClient);
            return result != null ? result : new Client();
        }
    }

    @Override
    public void update(final Client client) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(final Client client) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }
}
