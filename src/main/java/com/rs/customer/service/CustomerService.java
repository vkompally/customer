package com.rs.customer.service;

import com.rs.customer.dao.CustomerDAO;
import com.rs.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;



     public Customer addCustomer(Customer customer){

         return customerDAO.save(customer);
     }

     public List<Customer> getCustomers(){
         return customerDAO.findAll();
     }

     public Customer getCustomer(int customerId){

         return customerDAO.findById(customerId).get();
     }

     public Customer updateCustomer(int customerId, Customer customer){

         customer.setCustomerId(customerId);
         return customerDAO.save(customer);
     }

     public void deleteCustomer(int customerId){

         customerDAO.deleteById(customerId);
     }


}
