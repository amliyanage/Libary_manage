package org.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entity.Books;
import org.example.Entity.BorrowBook;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book_TransactionDto {
    private int id;
    private BorrowBook transaction;
    private Books book;
}
