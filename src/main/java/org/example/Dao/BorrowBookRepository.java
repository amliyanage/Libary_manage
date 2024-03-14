package org.example.Dao;

import org.example.Entity.BorrowBook;
import org.example.Entity.Member;

public interface BorrowBookRepository extends CrudUtil<BorrowBook>{
    BorrowBook getData(Member Id);

    int BookCount(Member data);
}
