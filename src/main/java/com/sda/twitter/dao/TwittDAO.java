package com.sda.twitter.dao;

import com.sda.twitter.model.Twitt;
import com.sda.twitter.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TwittDAO implements InterfaceDAO<Twitt> {

    private Session currentSession;

    private Session getCurrentSession(){
        if (currentSession==null){
            currentSession = HibernateUtils.openSession();
        }return currentSession;
    }

    @Override
    public void save(Twitt entity) {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        getCurrentSession().save(entity);
        currentTransaction.commit();
    }

    @Override
    public void update(Twitt entity) {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        getCurrentSession().update(entity);
        currentTransaction.commit();
    }

    @Override
    public Twitt findById(int id) {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        Twitt twitt = getCurrentSession().get(Twitt.class,id);
        currentTransaction.commit();
        return twitt;
    }

    @Override
    public void delete(Twitt entity) {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        getCurrentSession().delete(entity);
        currentTransaction.commit();
    }

    @Override
    public List<Twitt> findAll() {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        List<Twitt> twittList = getCurrentSession().createQuery("FROM "+Twitt.class).list();
        currentTransaction.commit();
        return twittList;
    }

    @Override
    public void deleteAll() {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        Query query = getCurrentSession().createQuery("DELETE FROM " + Twitt.class);
        query.executeUpdate();
        currentTransaction.commit();
    }
}
