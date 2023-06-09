package ru.itis.service;


import java.util.List;

public interface EntityCrudService<T, U> {
    T findById(U uuid);
    List<T> findAll();
    T createEntity(T entity);
    T updateEntity(T entity);
    void deleteEntity(U uuid);
}
