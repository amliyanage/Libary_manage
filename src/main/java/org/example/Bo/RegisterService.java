package org.example.Bo;

import org.example.Dto.MemberDto;

public interface RegisterService extends SuperService {
    int Register(MemberDto member);
}
