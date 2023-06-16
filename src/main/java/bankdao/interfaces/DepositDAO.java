package bankdao.interfaces;

import bankdao.entity.Deposit;

import java.util.List;

public interface DepositDAO {
    List<Deposit> getAllDeposit();
    Deposit getDepositById(int id);
    void save(Deposit deposit);
    void update(Deposit deposit);
    void delete(Deposit deposit);
}
