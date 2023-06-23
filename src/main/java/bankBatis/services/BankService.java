package bankBatis.services;

import bankBatis.main.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import bankBatis.mappers.BankMapper;
import bankdao.entity.Bank;

import java.util.List;

public class BankService {

    private final Logger logger = LogManager.getLogger(BankService.class);

    private final SqlSessionFactory sqlSessionFactory;

    public BankService() {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public Bank selectBankById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BankMapper bankMapper = session.getMapper(BankMapper.class);
            return bankMapper.selectBankById(id);
        }
    }

    public List<Bank> selectAllBanks() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BankMapper bankMapper = session.getMapper(BankMapper.class);
            return bankMapper.selectAllBanks();
        }
    }

    public void insertBank(Bank bank) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            BankMapper bankMapper = session.getMapper(BankMapper.class);
            bankMapper.insertBank(bank);
            logger.info("Bank id: " + bank.getId() + " -> Inserted successfully");
        }
    }

    public void updateBank(Bank bank) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            BankMapper bankMapper = session.getMapper(BankMapper.class);
            bankMapper.updateBank(bank);
            logger.info("Bank id: " + bank.getId() + " -> Updated successfully");
        }
    }

    public void deleteBank(int id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            BankMapper bankMapper = session.getMapper(BankMapper.class);
            bankMapper.deleteBank(id);
            logger.info("Bank id: " + id + " -> Deleted successfully");
        }
    }
}