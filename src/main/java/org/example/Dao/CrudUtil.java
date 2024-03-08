package org.example.Dao;

import org.example.Dto.MemberDto;

import java.util.List;

public interface CrudUtil<T> extends SuperDao{
    T getData(int Id);

    List<String> getOneData();

    int saved(T data);
}
