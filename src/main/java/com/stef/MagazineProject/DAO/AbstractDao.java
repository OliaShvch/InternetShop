package com.stef.MagazineProject.DAO;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public abstract class AbstractDao<T extends Identificator<PK>, PK extends Serializable> implements IGenDao<T, PK> {

    private Connection connection;


    public AbstractDao(Connection connection) {
        this.connection = connection;
    }



    public abstract String getSelectQuery();
    public abstract String getUpdateQuery();
    public abstract String getCreateQuery();
    public abstract String getDeleteQuery();
    public abstract ArrayList<T> parsData(ResultSet rs) throws DAOexception, SQLException;
    public abstract void parsUpdate(PreparedStatement prSt, T obj) throws DAOexception;
    public abstract void parsInsert(PreparedStatement prSt, T obj) throws DAOexception;


    @Override
    public T createEx(T obj) throws DAOexception {
        T temp;

        String query = getCreateQuery();


        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            parsInsert(prSt, obj);
            int count = prSt.executeUpdate();
            if (count != 1) throw new DAOexception("Error. Created more then 1 object " + count);
        } catch (Exception e) {
            throw new DAOexception(e);
        }



        /*query = getSelectQuery() + " WHERE id = LAST_INSERT_ID();";


        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            ResultSet rs = prSt.executeQuery();
            ArrayList<T> someList = parsData(rs);

            if (someList == null || someList.size() == 0)
                throw new DAOexception("Error with search created object by id");
            temp = someList.iterator().next();
        } catch (Exception e) {
            throw new DAOexception(e);
        }*/
        return obj;
    }


    @Override
    public T read(int id) throws DAOexception {
        ArrayList<T> someList;

        String query = getSelectQuery() + " WHERE id =?;";

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            prSt.setInt(1, id);
            ResultSet rs = prSt.executeQuery();
            someList = parsData(rs);
        } catch (Exception e) {
            throw new DAOexception(e);
        }

        if (someList == null || someList.size() == 0) return null;
        if (someList.size() > 1) {
            throw new DAOexception("Отримано забато даних");
        }
        return someList.iterator().next();
    }



    @Override
    public ArrayList<T> readAll() throws DAOexception {
        ArrayList<T> someList;

        String query = getSelectQuery()+" WHERE 1;";


        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            ResultSet resultSet = prSt.executeQuery();
            someList = parsData(resultSet);
        } catch (Exception e) {
            throw new DAOexception(e);
        }
        return someList;
    }


    @Override
    public void update(T obj) throws DAOexception {

        String query = getUpdateQuery();

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            parsUpdate(prSt, obj);
            int count;
            count = prSt.executeUpdate();
            if (count != 1) throw new DAOexception("Error. Modified more then 1 field " + count);
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }


    @Override
    public void delete(T obj) throws DAOexception {
        String query = getDeleteQuery();

        try (PreparedStatement prSt = connection.prepareStatement(query)) {
            try {
                prSt.setObject(1, obj.getId());
            } catch (Exception e) {
                throw new DAOexception(e);
            }

            int count = prSt.executeUpdate();
            if (count != 1) throw new DAOexception("Error. Deleted more then 1 field " + count);
        } catch (Exception e) {
            throw new DAOexception(e);
        }
    }
}