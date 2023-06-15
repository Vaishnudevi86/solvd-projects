package bankdao.interfaces;

import bankdao.model.Account;
import bankdao.model.TransactionType;

import java.util.List;

public interface TransactionTypeDAO {
    List<TransactionType> getAllTransactionType();
    TransactionType getTransactionTypeById(int id);
    void save(TransactionType transactionType);
    void update(TransactionType transactionType);
    void delete(TransactionType transactionType);
}
