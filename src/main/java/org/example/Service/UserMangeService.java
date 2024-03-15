package org.example.Service;

import org.example.Dto.MemberDto;

import java.util.ArrayList;

public interface UserMangeService extends SuperService {
    ArrayList<MemberDto> getAll();

    void delete(int Id);

}
