package org.example.Dao;

import org.example.Entity.Books;

public interface BookRepository extends CrudUtil<Books>{
    Books getData(String title);
}
