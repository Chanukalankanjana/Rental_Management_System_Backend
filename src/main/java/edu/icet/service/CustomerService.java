package edu.icet.service;

import edu.icet.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAllCustomer();

    void updateCustomer(Customer customer);

    boolean deleteCustomer(Integer id);

    Customer getStudentById(Integer id);

    Customer findByName(String name);
}
