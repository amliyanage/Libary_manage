package org.example.Bo.Custom;

import org.example.Bo.PendingBookService;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dao.CustomRepository;
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
