package bankdao.interfaces;

import bankdao.model.Account;
import bankdao.model.Bank;

import java.sql.SQLException;
import java.util.List;

public interface BankDAO {
        List<Bank> getAllBank() throws SQLException;
        Bank getBank(int bank_id) throws SQLException;
        void saveBank(Bank bank) throws SQLException;
        void updateBank(Bank bank) throws SQLException;
        void deleteBank(int bank_id) throws SQLException;
}

