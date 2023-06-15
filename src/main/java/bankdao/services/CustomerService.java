package bankdao.services;

import bankdao.interfaces.CustomerDAO;
import bankdao.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {

        private CustomerDAO customerDAO;

        public CustomerService(CustomerDAO customerDao) {
            this.customerDAO = customerDao;
        }

        public Customer getCustomerById(int id) {
            return customerDAO.getCustomerById(id);
        }

        public List<Customer> getAllCustomer() throws SQLException {
            return customerDAO.getAllCustomer();
        }

        public void saveCustomer(Customer customer) {
            customerDAO.save(customer);
        }

        public void updateCustomer(Customer customer) {
            customerDAO.update(customer);
        }

        public void deleteCustomer(Customer customer) {
            customerDAO.delete(customer);
        }
    }

