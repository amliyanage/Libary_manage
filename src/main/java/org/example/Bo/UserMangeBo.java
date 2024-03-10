package org.example.Bo;

import org.example.Dto.AdminDto;
import org.example.Dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

public interface UserMangeBo extends SuperBo{
    ArrayList<MemberDto> getAll();

    void delete(int Id);

}
