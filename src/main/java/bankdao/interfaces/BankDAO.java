package bankdao.interfaces;

import bankdao.entity.Bank;

import java.sql.SQLException;
import java.util.List;

public interface BankDAO {
        List<Bank> getAllBank() throws SQLException;
        Bank getBank(int bank_id) throws SQLException;
        void saveBank(Bank bankEntity) throws SQLException;
        void updateBank(Bank bankEntity) throws SQLException;
        void deleteBank(Bank bank_id) throws SQLException;
}

