package org.example.Bo;

import org.example.Dto.AdminDto;
import org.example.Entity.Admin;

public interface DashboardBo extends SuperBo{
    void Update(AdminDto Data) throws Exception;

    void Delete(int id);

    long BookCount();

    long MemberCount();

    long BranchCount();
}
