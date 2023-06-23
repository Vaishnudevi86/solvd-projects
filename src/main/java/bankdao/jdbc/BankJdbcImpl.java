package bankdao.jdbc;

import bankdao.entity.Bank;
import bankdao.interfaces.BankDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public  class BankJdbcImpl implements BankDAO {

    private static final String SELECT_QUERY = "SELECT * FROM Bank WHERE bank_id =?";
    private static final String SAVE_QUERY= "INSERT INTO Bank (bank_id,bank_name,address,contact_number) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ADDRESS="UPDATE Bank SET address =? WHERE bank_id=?";
    private static final String UPDATE_CONTACT="UPDATE Bank SET contact_number =? WHERE bank_id=?";
    private static final String DELETE_QUERY="DELETE FROM Bank WHERE bank_id =?";
    private static final String SELECT_ALL_QUERY= "SELECT * FROM Bank";
    private static final String SELECT_MAX_BANK_ID = "SELECT MAX(BANK_ID) max_bank_id FROM BANK_SCHEMA.BANK;";
    private Connection conn1;
    private ResultSet rs1;
    public BankJdbcImpl() {
    }
    public BankJdbcImpl(Connection conn1) {
        this.conn1 = conn1;
    }
    @Override
    public List<Bank> getAllBank() throws SQLException {
        List<Bank> bank = new ArrayList<>();
        Bank bank1 = null;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_ALL_QUERY)) {
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                bank1 = new Bank();
                bank1.setId(rs1.getInt("bank_id"));
                bank1.setName(rs1.getString("bank_name"));
                bank1.setAddress(rs1.getString("address"));
                bank1.setContactNumber(rs1.getString("contact_number"));
                bank.add(bank1);
            }
        }
        return bank;
    }
    @Override
    public Bank getBank(int bank_id) throws SQLException {
        Bank bank = null;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_QUERY)) {
            stmt1.setInt(1, bank_id);
            rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                bank = new Bank();
                bank.setId(rs1.getInt("bank_id"));
                bank.setName(rs1.getString("bank_name"));
                bank.setAddress(rs1.getString("address"));
                bank.setContactNumber(rs1.getString("contact_number"));
            }
        }
        return bank;
    }
    @Override
    public void saveBank(Bank bank) throws SQLException {
        int maxBankId = 0;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_MAX_BANK_ID)) {
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                maxBankId = rs1.getInt("max_bank_id");
            }
        }
        try (PreparedStatement stmt1 = conn1.prepareStatement(SAVE_QUERY)) {
            stmt1.setInt(1, maxBankId+1);
            stmt1.setString(2, bank.getName());
            stmt1.setString(3, bank.getAddress());
            stmt1.setString(4, bank.getContactNumber());
            stmt1.executeUpdate();
        }
    }
    @Override
    public void updateBank(Bank bank){
        try {
            if(bank.getAddress() != null){
                PreparedStatement stmt1 = conn1.prepareStatement(UPDATE_ADDRESS);
                stmt1.setString(1, bank.getAddress());
                stmt1.setInt(2, bank.getId());
                stmt1.executeUpdate();
            }
            if(bank.getContactNumber() != null){
                PreparedStatement stmt1 = conn1.prepareStatement(UPDATE_CONTACT);
                stmt1.setString(1, bank.getContactNumber());
                stmt1.setInt(2, bank.getId());
                stmt1.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteBank(Bank bank) throws SQLException {
        try (PreparedStatement stmt1 = conn1.prepareStatement(DELETE_QUERY)) {
            stmt1.setInt(1, bank.getId());
            stmt1.executeUpdate();
        }
    }
}
















