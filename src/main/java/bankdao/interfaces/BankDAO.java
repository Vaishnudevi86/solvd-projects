package bankdao.interfaces;

import bankdao.entity.BankEntity;

import java.sql.SQLException;
import java.util.List;

public interface BankDAO {
        List<BankEntity> getAllBank() throws SQLException;
        BankEntity getBank(int bank_id) throws SQLException;
        void saveBank(BankEntity bankEntity) throws SQLException;
        void updateBank(BankEntity bankEntity) throws SQLException;
        void deleteBank(BankEntity bank_id) throws SQLException;
}

