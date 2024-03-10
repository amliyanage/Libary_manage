package org.example.Bo;

import org.example.Dto.BranchDto;
import org.example.Dto.MemberDto;

import java.util.ArrayList;

public interface BranchBo extends SuperBo{
    ArrayList<BranchDto> getAll();

    int save(BranchDto branchDto);

    void update(BranchDto branchDto);

    void delete(int id);
}
