package bankdao.jdbc;

import bankdao.databaseConnection.DatabaseConnection;
import bankdao.interfaces.BankDAO;
import bankdao.model.Bank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public  class BankJdbcImpl implements BankDAO {

    private static final String SELECT_QUERY = "SELECT * FROM Bank WHERE bank_id =?";
    private static final String SAVE_QUERY= "INSERT INTO Bank (bank_id,bank_name,address,contact_number) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY="UPDATE Bank" + "SET bank_name =?, address =?, contact_number =?";
    private static final String DELETE_QUERY="DELETE FROM Bank WHERE bank_id =?";
    private static final String SELECT_ALL_QUERY= "SELECT * FROM Bank";
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
                bank1.setBank_id(rs1.getInt("bank_id"));
                bank1.setBank_name(rs1.getString("bank_name"));
                bank1.setAddress(rs1.getString("address"));
                bank1.setContact_number(rs1.getString("contact_number"));
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
                bank.setBank_id(rs1.getInt("bank_id"));
                bank.setBank_name(rs1.getString("bank_name"));
                bank.setAddress(rs1.getString("address"));
                bank.setContact_number(rs1.getString("contact_number"));
            }
        }
        return bank;
    }
    @Override
    public void saveBank(Bank bank) throws SQLException {
        try (PreparedStatement stmt1 = conn1.prepareStatement(SAVE_QUERY)) {
            stmt1.setString(2, bank.getBank_name());
            stmt1.setString(3, bank.getAddress());
            stmt1.setString(4, bank.getContact_number());
            stmt1.executeUpdate();
        }
    }
    @Override
    public void updateBank(Bank bank) throws SQLException {
        try (PreparedStatement stmt1 = conn1.prepareStatement(UPDATE_QUERY)) {
            stmt1.setString(2, bank.getBank_name());
            stmt1.setString(3, bank.getAddress());
            stmt1.setString(4, bank.getContact_number());
            stmt1.executeUpdate();
        }
    }
    public void deleteBank(int bank_id) throws SQLException {
        try (PreparedStatement stmt1 = conn1.prepareStatement(DELETE_QUERY)) {
            stmt1.setInt(1, bank_id);
            stmt1.executeUpdate();
        }
    }
}
















