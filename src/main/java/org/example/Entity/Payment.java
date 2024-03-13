package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    @Id
    @Column(name = "Payment_Id")
    private int id;

    @Column(name = "Amount")
    private double amount;

    @Column(name = "Date")
    private String date;

}
