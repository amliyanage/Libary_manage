package org.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BranchDto {
    private int Id;
    private String Name;
    private String Location;
    private String Email;
}
