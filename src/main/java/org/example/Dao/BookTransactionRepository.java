package org.example.Dao;

import org.example.Entity.Admin;
import org.example.Entity.Book_Transaction;
import org.example.Entity.Member;

import java.util.List;

public interface BookTransactionRepository extends CrudUtil<Book_Transaction>{
    List<Book_Transaction> bookTransactionData(String id);
}
