package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.Dto.BranchDto;

import javax.persistence.*;

@Entity
@Table(name = "Branch")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "Branch_Id" )
    private int Id;

    @Column( name = "Branch_Name" )
    private String Name;

    @Column( name = "Branch_Location" )
    private String Location;

    @Column( name = "Email" )
    private String Email;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public BranchDto toDto() {
        return new BranchDto(
                this.Id,
                this.Name,
                this.Location,
                this.Email
        );
    }
}
