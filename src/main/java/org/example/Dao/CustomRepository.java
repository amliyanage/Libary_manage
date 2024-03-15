package org.example.Dao;

import org.example.Dto.PendingDto;
import org.hibernate.Session;

import java.util.List;

public interface CustomRepository extends SuperRepository {

    List<PendingDto> getPendingDtoList();

    public void SetSession(Session session);
}
