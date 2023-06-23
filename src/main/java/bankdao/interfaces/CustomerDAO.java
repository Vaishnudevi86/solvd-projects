package bankdao.interfaces;

import bankdao.entity.Bank;
import bankdao.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomer() throws SQLException;
    Bank getCustomer(int customer_id) throws SQLException;
    void saveCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
    void deleteCustomer(int customer_id) throws SQLException;

    Customer getCustomerById(int id);

    void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
