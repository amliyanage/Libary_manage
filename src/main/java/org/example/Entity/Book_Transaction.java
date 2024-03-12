package org.example.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.awt.print.Book;

@Entity
@Table(name = "Book_Transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book_Transaction {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "transaction_id", insertable = false, updatable = false)
    private BorrowBook transaction;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Books book;

}
