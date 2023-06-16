package bankdao.services;

import bankdao.interfaces.LoanDAO;
import bankdao.entity.Loan;

import java.util.List;

public class LoanService {
    private LoanDAO loanDAO;

    public LoanService(LoanDAO loanDao) {
        this.loanDAO = loanDao;
    }

    public Loan getLoanById(int id) {
        return loanDAO.getLoanById(id);
    }

    public List<Loan> getAllLoan() {
        return loanDAO.getAllLoan();
    }

    public void saveLoan(Loan loan) {
        loanDAO.save(loan);
    }

    public void updateLoan(Loan loan) {
        loanDAO.update(loan);
    }

    public void deleteLoan(Loan loan) {
        loanDAO.delete(loan);
    }
}


