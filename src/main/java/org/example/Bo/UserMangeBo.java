package org.example.Bo;

import org.example.Dto.AdminDto;

import java.util.ArrayList;

public interface UserMangeBo extends SuperBo{
    ArrayList<AdminDto> getAll();

    int save(AdminDto admin);
}
