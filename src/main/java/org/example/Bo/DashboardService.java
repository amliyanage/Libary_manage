package org.example.Bo;

import org.example.Dto.AdminDto;

public interface DashboardService extends SuperService {
    void Update(AdminDto Data) throws Exception;

    void Delete(int id);

    long BookCount();

    long MemberCount();

    long BranchCount();
}
