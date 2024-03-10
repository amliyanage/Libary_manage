package org.example.Bo.Custom;

import org.example.Bo.BranchBo;
import org.example.Dao.BranchDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dto.BranchDto;
import org.example.Entity.Branch;

import java.util.ArrayList;

public class BranchBoImpl implements BranchBo {

    BranchDao branchDao = (BranchDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.Branch);

    @Override
    public ArrayList<BranchDto> getAll() {
        ArrayList<Branch> all = branchDao.getAll();
        ArrayList<BranchDto> branchDtos = new ArrayList<>();
        for (Branch branch : all) {
            branchDtos.add(new BranchDto(branch.getId(), branch.getName(), branch.getLocation(), branch.getEmail()));
        }
        return branchDtos;
    }

    @Override
    public int save(BranchDto branchDto) {
        return branchDao.saved(new Branch(branchDto.getId(), branchDto.getName(), branchDto.getLocation(), branchDto.getEmail()));
    }

    @Override
    public void update(BranchDto branchDto) {
        branchDao.Update(new Branch(branchDto.getId(), branchDto.getName(), branchDto.getLocation(), branchDto.getEmail()));
    }

    @Override
    public void delete(int id) {
        branchDao.Delete(id);
    }
}
