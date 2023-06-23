package bankBatis.mappers;

import bankdao.entity.Bank;

import java.util.List;

public interface BankMapper {

    Bank selectBankById(int id);

    List<Bank> selectAllBanks();

    void insertBank(Bank bank);

    void updateBank(Bank bank);

    void deleteBank(int id);
}