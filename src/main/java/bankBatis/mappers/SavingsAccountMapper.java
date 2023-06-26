package bankBatis.mappers;

import bankdao.entity.SavingsAccount;

import java.util.List;

public interface SavingsAccountMapper {

    SavingsAccount selectSavingsAccountById(int id);

    List<SavingsAccount> selectSavingsAccountsByCustomerId();

    void insertSavingsAccount(SavingsAccount savingsAccount);

    void updateSavingsAccount(SavingsAccount savingsAccount);

    void deleteSavingsAccount(int id);
}