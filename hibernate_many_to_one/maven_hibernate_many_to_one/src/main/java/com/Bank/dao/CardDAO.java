package com.Bank.dao;
import com.Bank.data.Card;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CardDAO implements DAO<Card, Integer> {
    private SessionFactory factory;
    public CardDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Card card) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(card);
            session.getTransaction().commit();
        }
    }
    @Override
    public Card read(Integer id) {
        try(Session session = factory.openSession()) {
            Card result = session.get(Card.class, id);
            if(result != null) {
                Hibernate.initialize(result.getClient());
            }
            return result;
        }
    }
    @Override
    public void update(Card card) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(card);
            session.getTransaction().commit();
        }
    }
    @Override
    public void delete(Card card) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(card);
            session.getTransaction().commit();
        }
    }
}
