package org.example.Dao;

public interface CrudUtil<T> extends SuperDao{
    T getData(int Id);
}
