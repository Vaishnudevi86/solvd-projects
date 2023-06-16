package bankdao.services;

import bankdao.entity.BankEntity;
import bankdao.interfaces.BankDAO;

import java.sql.SQLException;
import java.util.List;

    public class BankService {
    private BankDAO bankDAO;

    public BankService(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    public BankEntity getBankById(int id) throws SQLException {
        return bankDAO.getBank(id);
    }

    public List<BankEntity> getAllBanks() throws SQLException {
        return bankDAO.getAllBank();
    }

    public void saveBank(BankEntity bankEntity) throws SQLException {
        bankDAO.saveBank(bankEntity);
    }

    public void updateBank(BankEntity bankEntity) throws SQLException {
        bankDAO.updateBank(bankEntity);
    }

    public void deleteBank(BankEntity bankId) throws SQLException {
        bankDAO.deleteBank(bankId);
    }
}
