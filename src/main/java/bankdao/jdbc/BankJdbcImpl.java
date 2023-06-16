package bankdao.jdbc;

import bankdao.entity.BankEntity;
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
    public List<BankEntity> getAllBank() throws SQLException {
        List<BankEntity> bankEntity = new ArrayList<>();
        BankEntity bankEntity1 = null;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_ALL_QUERY)) {
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                bankEntity1 = new BankEntity();
                bankEntity1.setBank_id(rs1.getInt("bank_id"));
                bankEntity1.setBank_name(rs1.getString("bank_name"));
                bankEntity1.setAddress(rs1.getString("address"));
                bankEntity1.setContact_number(rs1.getString("contact_number"));
                bankEntity.add(bankEntity1);
            }
        }
        return bankEntity;
    }
    @Override
    public BankEntity getBank(int bank_id) throws SQLException {
        BankEntity bankEntity = null;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_QUERY)) {
            stmt1.setInt(1, bank_id);
            rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                bankEntity = new BankEntity();
                bankEntity.setBank_id(rs1.getInt("bank_id"));
                bankEntity.setBank_name(rs1.getString("bank_name"));
                bankEntity.setAddress(rs1.getString("address"));
                bankEntity.setContact_number(rs1.getString("contact_number"));
            }
        }
        return bankEntity;
    }
    @Override
    public void saveBank(BankEntity bankEntity) throws SQLException {
        int maxBankId = 0;
        try (PreparedStatement stmt1 = conn1.prepareStatement(SELECT_MAX_BANK_ID)) {
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                maxBankId = rs1.getInt("max_bank_id");
            }
        }
        try (PreparedStatement stmt1 = conn1.prepareStatement(SAVE_QUERY)) {
            stmt1.setInt(1, maxBankId+1);
            stmt1.setString(2, bankEntity.getBank_name());
            stmt1.setString(3, bankEntity.getAddress());
            stmt1.setString(4, bankEntity.getContact_number());
            stmt1.executeUpdate();
        }
    }
    @Override
    public void updateBank(BankEntity bankEntity){
        try {
            if(bankEntity.getAddress() != null){
                PreparedStatement stmt1 = conn1.prepareStatement(UPDATE_ADDRESS);
                stmt1.setString(1, bankEntity.getAddress());
                stmt1.setInt(2, bankEntity.getBank_id());
                stmt1.executeUpdate();
            }
            if(bankEntity.getContact_number() != null){
                PreparedStatement stmt1 = conn1.prepareStatement(UPDATE_CONTACT);
                stmt1.setString(1, bankEntity.getContact_number());
                stmt1.setInt(2, bankEntity.getBank_id());
                stmt1.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteBank(BankEntity bankEntity) throws SQLException {
        try (PreparedStatement stmt1 = conn1.prepareStatement(DELETE_QUERY)) {
            stmt1.setInt(1, bankEntity.getBank_id());
            stmt1.executeUpdate();
        }
    }
}
















