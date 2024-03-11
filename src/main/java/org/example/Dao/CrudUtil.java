package org.example.Dao;

import java.util.ArrayList;
import java.util.List;

public interface CrudUtil<T> extends SuperRepository {
    T getData(String Id);

    List<String> getOneData();

    int saved(T data);

    ArrayList<T> getAll();

    void Update(T Data);
    void Delete(int Id);
    long Count();
}
