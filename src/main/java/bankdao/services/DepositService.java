package bankdao.services;
import bankdao.interfaces.DepositDAO;
import bankdao.entity.Deposit;

import java.util.List;

public class DepositService {
    private DepositDAO depositDAO;

    public DepositService(DepositDAO depositDao) {
        this.depositDAO = depositDao;
    }

    public Deposit getDepositById(int id) {
        return depositDAO.getDepositById(id);
    }

    public List<Deposit> getAllDeposit() {
        return depositDAO.getAllDeposit();
    }

    public void saveDeposit(Deposit deposit) {
        depositDAO.save(deposit);
    }

    public void updateDeposit(Deposit deposit) {
        depositDAO.update(deposit);
    }

    public void deleteDeposit(Deposit deposit) {
        depositDAO.delete(deposit);
    }
}

