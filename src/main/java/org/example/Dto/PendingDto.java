package org.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PendingDto {
    private int id;
    private int memberId;
    private String MemberName;
    private String DueDate;
}
