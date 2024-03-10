package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
@Data
@AllArgsConstructor
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

}
