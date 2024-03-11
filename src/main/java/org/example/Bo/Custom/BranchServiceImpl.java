package org.example.Bo.Custom;

import org.example.Bo.BranchService;
import org.example.Dao.BranchRepository;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dto.BranchDto;
import org.example.Entity.Branch;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class BranchServiceImpl implements BranchService {

    private Session session;

    private Transaction transaction;
    private final BranchRepository branchRepository = (BranchRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Branch);

    @Override
    public ArrayList<BranchDto> getAll() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        ArrayList<Branch> all = branchRepository.getAll();
        ArrayList<BranchDto> branchDtos = new ArrayList<>();
        for (Branch branch : all) {
            branchDtos.add(new BranchDto(branch.getId(), branch.getName(), branch.getLocation(), branch.getEmail()));
        }
        return branchDtos;
    }

    @Override
    public int save(BranchDto branchDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        int saved =  branchRepository.saved(new Branch(branchDto.getId(), branchDto.getName(), branchDto.getLocation(), branchDto.getEmail(), AdminServiceImpl.admin));
        transaction = session.beginTransaction();
        transaction.commit();
        if (saved > 0) {
            return saved;
        }
        else {
            transaction.rollback();
            return -1;
        }
    }

    @Override
    public void update(BranchDto branchDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        branchRepository.Update(new Branch(branchDto.getId(), branchDto.getName(), branchDto.getLocation(), branchDto.getEmail(),AdminServiceImpl.admin));
        transaction = session.beginTransaction();
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        branchRepository.SetSession(session);
        branchRepository.Delete(id);
        transaction = session.beginTransaction();
        transaction.commit();
    }
}
