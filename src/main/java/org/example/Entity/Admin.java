package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.Dto.AdminDto;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Admin")
@Data
@NoArgsConstructor
@ToString
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "Admin_Id" )
    private int Id;

    @Column( name = "Name" )
    private String Name;

    @Column( name = "Username" )
    private String Username;

    @Column( name = "Password" )
    private String Password;

    @Column( name = "Email" )
    private String Email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
    private List<Branch> branches = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "admin")
    private List<Books> books = new ArrayList<>();

    public AdminDto toDto() {
        return new AdminDto(
                this.Id,
                this.Name,
                this.Username,
                this.Password,
                this.Email
        );

    }

    public Admin(int Id , String Name , String Username , String Password , String Email){
        this.Id = Id;
        this.Name = Name;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
    }
}
