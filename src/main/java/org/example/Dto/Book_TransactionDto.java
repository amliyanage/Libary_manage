package org.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Entity.Books;
import org.example.Entity.BorrowBook;
import org.example.Entity.TransactionDetailPK;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book_TransactionDto {
    private TransactionDetailPK id;
    private BorrowBook transaction;
    private Books book;
}
