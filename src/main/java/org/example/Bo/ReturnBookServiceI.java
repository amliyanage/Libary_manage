package org.example.Bo;

import org.example.Entity.BorrowBook;

import java.util.List;

public interface ReturnBookServiceI extends SuperService{
    List<Integer> getAllId();

    BorrowBook getPendingData(String value);

    boolean returnBook(BorrowBook borrowBook);

    List<BorrowBook> getAllTableData();
}
