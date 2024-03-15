package org.example.Service;

import org.example.Dto.MemberDto;

public interface RegisterService extends SuperService {
    int Register(MemberDto member);
}
