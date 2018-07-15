package com.sda.twitter.dao;

import com.sda.twitter.model.Twitt;
import com.sda.twitter.model.User;
import com.sda.twitter.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements InterfaceDAO<User> {

    private Session currentSession;

    private Session getCurrentSession(){
        if (currentSession==null){
            currentSession = HibernateUtils.openSession();
        }
        return currentSession;
    }

    @Override
    public void save(User entity) {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        getCurrentSession().save(entity);
        currentTransaction.commit();
    }

    @Override
    public void update(User entity) {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        getCurrentSession().update(entity);
        currentTransaction.commit();
    }

    @Override
    public User findById(int id) {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        User user = getCurrentSession().get(User.class,id);
        currentTransaction.commit();
        return user;
    }

    @Override
    public void delete(User entity) {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        getCurrentSession().delete(entity);
        currentTransaction.commit();
    }

    @Override
    public List<User> findAll() {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        List<User> userList = getCurrentSession().createQuery("FROM "+User.class).list();
        currentTransaction.commit();
        return userList;
    }

    @Override
    public void deleteAll() {
        Transaction currentTransaction;
        currentTransaction = getCurrentSession().beginTransaction();
        Query query = getCurrentSession().createQuery("DELETE FROM " + User.class);
        query.executeUpdate();
        currentTransaction.commit();
    }
}
