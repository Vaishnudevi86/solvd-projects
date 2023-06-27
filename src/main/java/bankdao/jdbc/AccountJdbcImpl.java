package bankdao.jdbc;

import bankdao.entity.Account;
import bankdao.entity.SavingsAccount;
import bankdao.interfaces.AccountDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountJdbcImpl implements AccountDAO {
    private static final String SELECT_QUERY = "SELECT * FROM Account WHERE account_id =?";
    private static final String SAVE_QUERY= "INSERT INTO Account (account_id,branch_id,account_type,balance,account_holder_id) VALUES (?, ?, ?, ?,?)";
    private static final String UPDATE_QUERY="UPDATE Account" + "SET branch_id =?, account_type =?, balance =?";
    private static final String DELETE_QUERY="DELETE FROM Account WHERE account_id =?";
    private static final String SELECT_ALL_QUERY= "SELECT * FROM Account";
    private static final String SELECT_MAX_ACCOUNT_ID = "SELECT MAX(ACCOUNT_ID) max_account_id FROM BANK_SCHEMA.ACCOUNT;";
    private Connection conn1;
    private ResultSet rs1;
    public AccountJdbcImpl() {
    }
    public AccountJdbcImpl(Connection conn1) {
        this.conn1 = conn1;
    }
    @Override
    public Account getAccountById(int account_id) {
        Account account = null;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_QUERY)) {
            stmt1.setInt(1, account_id);
            rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                account = new Account();
                account.setAccountId(rs1.getInt("account_id"));
                account.setBranchId(rs1.getString("branch_id"));
                account.setBalance(rs1.getDouble("balance"));
                account.setAccountType(rs1.getString("account_type"));
                account.setAccountHolderId(rs1.getString("account_holder_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }
    @Override
    public void save(Account account) {
        int maxAccountId = 0;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_MAX_ACCOUNT_ID)) {
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                maxAccountId = rs1.getInt("max_account_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement stmt1 = conn1.prepareStatement(SAVE_QUERY)) {
            stmt1.setInt(1, maxAccountId+1);
            stmt1.setString(2, account.getBranchId());
            stmt1.setString(3, account.getAccountType());
            stmt1.setDouble(4, account.getBalance());
            stmt1.setString(5, account.getAccountHolderId());
            stmt1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update(Account account) throws SQLException {
        try (PreparedStatement stmt1 = conn1.prepareStatement(UPDATE_QUERY)) {
            stmt1.setString(2, account.getBranchId());
            stmt1.setString(3, account.getAccountType());
            stmt1.setDouble(4, account.getBalance());
            stmt1.setString(5, account.getAccountHolderId());
            stmt1.executeUpdate();
        }
    }

    public void delete(int account_id) {
        try (PreparedStatement stmt1 = conn1.prepareStatement(DELETE_QUERY)) {
            stmt1.setInt(1, account_id);
            stmt1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> getAllAccount() {
        List<Account> accountEntities = new ArrayList<>();
        Account account = null;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_ALL_QUERY)) {
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                account = new SavingsAccount();
                account.setAccountType(rs1.getString("Account_type"));
                account.setAccountId(rs1.getInt("Account_id"));
                account.setAccountHolderId(rs1.getString("Account_holder_id"));
                account.setBranchId(rs1.getString("Branch_id"));
                accountEntities.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accountEntities;
    }
}







