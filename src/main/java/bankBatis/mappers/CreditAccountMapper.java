package bankBatis.mappers;

import bankdao.entity.CreditAccount;

import java.util.List;

public interface CreditAccountMapper {

    CreditAccount selectCreditAccountById(int id);

    List<CreditAccount> selectCreditAccountsByCustomerId();

    void insertCreditAccount(CreditAccount creditAccount);

    void updateCreditAccount(CreditAccount creditAccount);

    void deleteCreditAccount(int id);
}