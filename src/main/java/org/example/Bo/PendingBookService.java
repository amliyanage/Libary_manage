package org.example.Bo;

import org.example.Dto.PendingDto;

import java.util.List;

public interface PendingBookService extends SuperService{
    List<PendingDto> getPendingBookDetails();
}
