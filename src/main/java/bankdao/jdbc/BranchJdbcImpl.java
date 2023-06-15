package bankdao.jdbc;
import bankdao.interfaces.BranchDAO;
import bankdao.model.Branch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public abstract class BranchJdbcImpl implements BranchDAO {

        private static final String SELECT_QUERY = "SELECT * FROM Branch WHERE branch_id =?";
        private static final String SAVE_QUERY = "INSERT INTO Branch (branch_id,branch_name,bank_id,address,contact_number) VALUES (?, ?, ?, ?, ?)";
        private static final String UPDATE_QUERY = "UPDATE  Branch" + "SET branch_name =?,bank_id=?, address =?, contact_number =?";
        private static final String DELETE_QUERY = "DELETE FROM Branch WHERE branch_id =?";
        private static final String SELECT_ALL_QUERY = "SELECT * FROM Branch";
        private Connection conn1;
        private ResultSet rs1;

        public BranchJdbcImpl() {
        }

        public BranchJdbcImpl(Connection conn1) {
            this.conn1 = conn1;
        }

        @Override
        public List<Branch> getAllBranch() throws SQLException {
            List<Branch> branch = new ArrayList<>();
            Branch branch1 = null;
            try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_ALL_QUERY)) {
                rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    branch1 = new Branch();
                    branch1.setBranch_id(rs1.getInt("branch_id"));
                    branch1.setBranch_name(rs1.getString("branch_name"));
                    branch1.setBank_id(rs1.getInt(""));
                    branch1.setContact_number(rs1.getString("contact_number"));
                    branch.add(branch1);
                }
            }
            return branch;
        }

      @Override
        public Branch getBranch(int branch_id) throws SQLException {
            Branch branch = null;
            try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_QUERY)) {
                stmt1.setInt(1, branch_id);
                rs1 = stmt1.executeQuery();
                if (rs1.next()) {
                    branch = new Branch();
                    branch.setBranch_id(rs1.getInt("branch_id"));
                    branch.setBranch_name(rs1.getString("branch_name"));
                    branch.setBank_id(rs1.getInt("bank_id"));
                    branch.setAddress(rs1.getString("address"));
                    branch.setContact_number(rs1.getString("contact_number"));
                }
            }
            return branch;
        }

      @Override
        public void saveBranch(Branch branch) throws SQLException {
            try (PreparedStatement stmt1 = conn1.prepareStatement(SAVE_QUERY)) {
                stmt1.setInt(1, branch.getBranch_id());
                stmt1.setString(2, branch.getBranch_name());
                stmt1.setInt(3, branch.getBank_id());
                stmt1.setString(4, branch.getAddress());
                stmt1.setString(5, branch.getContact_number());
                stmt1.executeUpdate();
            }
        }

        @Override
        public void updateBranch(Branch branch) throws SQLException {
            try (PreparedStatement stmt1 = conn1.prepareStatement(UPDATE_QUERY)) {
                stmt1.setInt(1, branch.getBranch_id());
                stmt1.setString(2, branch.getBranch_name());
                stmt1.setInt(3, branch.getBank_id());
                stmt1.setString(4, branch.getAddress());
                stmt1.setString(5, branch.getContact_number());
                stmt1.executeUpdate();
            }
        }
        public void deleteBranch(int branch_id) throws SQLException {
            try (PreparedStatement stmt1 = conn1.prepareStatement(DELETE_QUERY)) {
                stmt1.setInt(1, branch_id);
                stmt1.executeUpdate();
            }
        }
    }
