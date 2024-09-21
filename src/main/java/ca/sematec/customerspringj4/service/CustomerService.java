package ca.sematec.customerspringj4.service;

import ca.sematec.customerspringj4.model.Customer;
import ca.sematec.customerspringj4.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }

    public Customer findById(long id) {

       Optional<Customer> optionalCustomer=customerRepository.findById(id);
       if(optionalCustomer.isPresent()){
           return optionalCustomer.get();
       }else {
           throw new EntityNotFoundException("Customer not found");
       }
    }

    public List<Customer> findAll(int offset, int pageNumber) {
        Pageable pageable = PageRequest.of(offset, pageNumber);
        return customerRepository.findByName(pageable);
    }

    public Customer update(Customer customer) {
        Customer customer1=findById(customer.getId());
        customer1.setName(customer.getName());
        return customerRepository.save(customer1);
    }



}

