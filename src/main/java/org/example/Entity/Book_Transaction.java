package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Book_Transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book_Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Borrow_id")
    private BorrowBook transaction;

    @ManyToOne
    @JoinColumn(name = "Book_Id")
    private Books book;

    @Override
    public String toString() {
        return "Book_Transaction{" +
                "id=" + id +
                ", transaction=" + transaction +
                ", book=" + book +
                '}';
    }
}
