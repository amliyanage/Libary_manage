package org.example.Dao;

import java.util.List;

public interface CrudUtil<T> extends SuperDao{
    T getData(int Id);

    List<String> getOneData();
}
