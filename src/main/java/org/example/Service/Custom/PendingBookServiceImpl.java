package org.example.Service.Custom;

import org.example.Service.PendingBookService;
import org.example.Repository.Custom.RepositoryFactory;
import org.example.Repository.CustomRepository;
import org.example.Dto.PendingDto;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class PendingBookServiceImpl implements PendingBookService {
    private Session session;
    private final CustomRepository customRepository = (CustomRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Pending);

    @Override
    public List<PendingDto> getPendingBookDetails() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        customRepository.SetSession(session);
        List<PendingDto> borrowBookDetails = customRepository.getPendingDtoList();
        session.close();
        System.out.println(2);
        return borrowBookDetails;
    }
}
