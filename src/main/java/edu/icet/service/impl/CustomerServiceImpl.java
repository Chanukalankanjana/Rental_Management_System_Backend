package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final ObjectMapper mapper;
    @Override
    public void addCustomer(Customer customer) {
        CustomerEntity customerEntity = mapper.convertValue(customer, CustomerEntity.class);
        repository.save(customerEntity);
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerLiist = new ArrayList();
        Iterable<CustomerEntity> all = repository.findAll();

        all.forEach(customerEntity -> {
            Customer customer = mapper.convertValue(customerEntity, Customer.class);
            customerLiist.add(customer);
        });
        return customerLiist;
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (repository.existsById(customer.getId())){
            CustomerEntity customerEntity = mapper.convertValue(customer, CustomerEntity.class);
            repository.save(customerEntity);
        }
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Customer getStudentById(Integer id) {
        if (repository.existsById(id)){
            Optional<CustomerEntity> byId = repository.findById(id);
            return mapper.convertValue(byId, Customer.class);
        }
        return null;
    }
}
