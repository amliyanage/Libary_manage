package org.example.Dao;

import org.example.Dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

public interface CrudUtil<T> extends SuperDao{
    T getData(String Id);

    List<String> getOneData();

    int saved(T data);

    ArrayList<T> getAll();

    void Update(T Data);
    void Delete(int Id);

    long Count();
}
