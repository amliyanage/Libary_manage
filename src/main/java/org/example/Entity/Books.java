package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table( name = "Book")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Books {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "Book_Id")
    private int Id;

    @Column( name = "Title" )
    private String title;

    @Column( name = "Autor" )
    private String Autor;

    @Column( name = "Dis" )
    private String dis;

    @Column( name = "Genre" )
    private String genre;

    @Column( name = "Available")
    private String available;
}
