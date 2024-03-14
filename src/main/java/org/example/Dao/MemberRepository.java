package org.example.Dao;

import org.example.Bo.Custom.MemberServiceImpl;
import org.example.Entity.Member;

public interface MemberRepository extends CrudUtil<Member>{
    Member CheckEmail(String email);
}
