package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Member")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Member_Id" )
    private int Id;

    @Column( name = "Username" )
    private String Username;

    @Column( name = "Password" )
    private String Password;

    @Column( name = "Email" )
    private String Email;

}
