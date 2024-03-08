package org.example.Bo;

import org.example.Dto.MemberDto;
import org.example.Entity.Member;

public interface RegisterBo extends SuperBo{
    int Register(MemberDto member);
}
