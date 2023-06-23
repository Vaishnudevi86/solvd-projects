package bankdao.services;

import bankdao.entity.Bank;
import bankdao.interfaces.BankDAO;

import java.sql.SQLException;
import java.util.List;

    public class BankService {
    private BankDAO bankDAO;

    public BankService(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    public Bank getBankById(int id) throws SQLException {
        return bankDAO.getBank(id);
    }

    public List<Bank> getAllBanks() throws SQLException {
        return bankDAO.getAllBank();
    }

    public void saveBank(Bank bank) throws SQLException {
        bankDAO.saveBank(bank);
    }

    public void updateBank(Bank bank) throws SQLException {
        bankDAO.updateBank(bank);
    }

    public void deleteBank(Bank bankId) throws SQLException {
        bankDAO.deleteBank(bankId);
    }
}
