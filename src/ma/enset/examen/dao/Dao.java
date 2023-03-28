package ma.enset.examen.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    List<T> findAll() throws SQLException;
    T findByID(int id) throws SQLException;
    T save(T t) throws SQLException;
    T delete(T t) throws SQLException;
    T update(T t) throws SQLException;
}
