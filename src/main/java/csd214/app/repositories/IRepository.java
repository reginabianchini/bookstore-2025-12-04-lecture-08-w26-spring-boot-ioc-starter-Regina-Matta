package csd214.app.repositories;
import java.util.List;

public interface IRepository<T> {
    T save(T entity);
    T findById(Long id);
    List<T> findAll();
    void delete(Long id);
    long count();
    int deleteAll();
    String getDataSourceType(); // New for Lecture 7
    void close();
}