package org.example.Dao;

import org.example.Entity.Books;

public interface BookDao extends CrudUtil<Books>{
    Books getData(String title);
}
