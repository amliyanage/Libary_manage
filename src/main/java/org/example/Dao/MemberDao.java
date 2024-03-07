package org.example.Dao;

import org.example.Entity.Member;

public interface MemberDao extends CrudUtil<Member>{
    Member getData(int Id);
}
