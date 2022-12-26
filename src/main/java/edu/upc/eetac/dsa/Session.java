package edu.upc.eetac.dsa;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity);
    void close() throws SQLException;
    Object get(Class theClass, String id);

    Object getElementos(Class theClass, String parametro, String valor);

    void update(Object object);
    void delete(Object object);
    List<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    void deleteRecords(Class theClass);
    List<Object> query(String query, Class theClass, HashMap params);

    //void comprarObjeto(String idPou,String idProducto, int cantidad);
}
