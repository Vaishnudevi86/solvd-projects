package bankdao.interfaces;

import bankdao.model.Account;
import bankdao.model.Bank;
import bankdao.model.Branch;

import java.sql.SQLException;
import java.util.List;

public interface BranchDAO {
    List<Branch> getAllBranch() throws SQLException;
    Branch getBranch(int branch_id) throws SQLException;
    void saveBranch(Branch branch) throws SQLException;
    void updateBranch(Branch branch) throws SQLException;
    void deleteBranch(int branch_id) throws SQLException;

    void update(Branch branch);

    void save(Branch branch);

    Branch getBranchById(int id);

    void delete(Branch branch);
}


