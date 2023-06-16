package bankdao.interfaces;

import bankdao.entity.Loan;

import java.util.List;

public interface LoanDAO {
        List<Loan> getAllLoan();
        Loan getLoanById(int id);
        void save(Loan loan);
        void update(Loan loan);
        void delete(Loan loan);
    }

