package edu.upc.eetac.dsa.util;

import java.lang.reflect.InvocationTargetException;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException  {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        sb.append("ID");
        for (String field: fields) {
            sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for (String field: fields) {
            sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }

    public static String createQueryUPDATE(Object object) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("UPDATE ").append(object.getClass().getSimpleName());
        buffer.append(" SET ");

        String[] fields = ObjectHelper.getFields(object);
        for (String field : fields) {
            buffer.append(field).append(" = ?, ");
        }
        buffer.setLength(buffer.length()-2);
        buffer.append(" WHERE ").append(ObjectHelper.getIdAttributeName(object.getClass())).append(" = ?");

        return buffer.toString();
    }
    public static String createQueryDELETE(Object object) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("DELETE FROM ").append(object.getClass().getSimpleName());
        buffer.append(" WHERE ").append(ObjectHelper.getIdAttributeName(object.getClass())).append(" = ?");

        return buffer.toString();
    }

    public static String createQueryDeleteRecords(Class theClass) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM ").append(theClass.getSimpleName());
        return query.toString();
    }

    public static String createQuerySelectAll(Class theClass) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM ").append(theClass.getSimpleName());
        return query.toString();
    }

}
