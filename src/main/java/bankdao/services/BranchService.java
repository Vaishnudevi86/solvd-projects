package bankdao.services;

import bankdao.interfaces.BranchDAO;
import bankdao.entity.Branch;

import java.sql.SQLException;
import java.util.List;

public class BranchService {
    private BranchDAO branchDAO;

    public BranchService(BranchDAO branchDao) {
        this.branchDAO = branchDao;
    }

    public Branch getBranchById(int id) {
        return branchDAO.getBranchById(id);
    }

    public List<Branch> getAllBranch() throws SQLException {
        return branchDAO.getAllBranch();
    }

    public void saveBranch(Branch branch) {
        branchDAO.save(branch);
    }

    public void updateBranch(Branch branch) {
        branchDAO.update(branch);
    }

    public void deleteBranch(Branch branch) {
        branchDAO.delete(branch);
    }
}

