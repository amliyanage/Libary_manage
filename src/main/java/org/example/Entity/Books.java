package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.Dto.BookDto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Book")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Book_Id")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "Dis")
    private String dis;

    @Column(name = "Genre")
    private String genre;

    @Column(name = "Available")
    private String available;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public BookDto toDto() {
        return new BookDto(
                this.id,
                this.title,
                this.autor,
                this.dis,
                this.genre,
                this.available
        );
    }
    
}
