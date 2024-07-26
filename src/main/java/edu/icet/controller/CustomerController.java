package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
//http://localhost:8080/customer
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping("/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

//    @GetMapping("/get-all")
//    List<Customer> getAllCustomer(){
//        return service.getAllCustomer();
//    }
//
//    @PutMapping("/update-student")
//    void updateStudent(@RequestBody Customer customer){
//        service.updateCustomer(customer);
//    }
}
