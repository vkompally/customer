package com.rs.customer.api;

import com.rs.customer.model.Customer;
import com.rs.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer (@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    // Below not working
    @GetMapping(value = "/customerId")
    public Customer getCustomer(@PathVariable("customerId") int customerId){
        return customerService.getCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerID") int customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);

    }

}
