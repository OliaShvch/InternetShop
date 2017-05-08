package com.stef.MagazineProject.DAO;


import java.io.Serializable;

import java.util.ArrayList;


public interface IGenDao<T, PK extends Serializable> {

    T createEx(T obj) throws DAOexception;
    T read(int key) throws DAOexception;
    ArrayList<T> readAll() throws DAOexception;
    void update(T obj) throws DAOexception;
    void delete(T obj) throws DAOexception;

}

/*
public interface IGenDAO<T, PK extends Serializable> {
    public T create() throws DAOexception;
    public T create(T object) throws DAOexception;
    public T read(PK key)throws DAOexception;
    public void update(T obj)throws DAOexception;
    public void delete(T obj)throws DAOexception;
    public ArrayList<T> readAll()throws DAOexception;
*/

