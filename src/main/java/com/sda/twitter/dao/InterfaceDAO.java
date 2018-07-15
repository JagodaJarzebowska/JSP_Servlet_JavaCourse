package com.sda.twitter.dao;

import java.util.List;

public interface InterfaceDAO<T> {

    void save(T entity);
    void update(T entity);
    T findById(int id);
    void delete(T entity);
    List<T> findAll();
    void deleteAll();

}
