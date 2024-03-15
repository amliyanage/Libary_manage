package org.example.Repository;

import org.example.Entity.Member;

public interface MemberRepository extends CrudUtil<Member>{
    Member getId(int id);

    Member CheckEmail(String email);
}
