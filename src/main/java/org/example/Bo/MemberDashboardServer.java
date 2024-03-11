package org.example.Bo;

import org.example.Dto.MemberDto;

public interface MemberDashboardServer extends SuperService{
    MemberDto getData(String username);

    void Update(MemberDto memberDto);
}
