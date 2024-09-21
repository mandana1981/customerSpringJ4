package ca.sematec.customerspringj4.controller;

import ca.sematec.customerspringj4.model.Customer;
import ca.sematec.customerspringj4.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return ResponseEntity.ok(customer);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        customerService.findById(id);
        return ResponseEntity.ok(customerService.findById(id));
    }
    @Operation(summary = "list all customers",description = "will return whole object as List",operationId="get all customers")
    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }
@GetMapping("/{id1}/{id2}")
public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable int id1,
                                                        @PathVariable int id2) {
List<Customer> customerList=customerService.findAll(id1,id2);
return new ResponseEntity<List<Customer>>(customerList,new  HttpHeaders(),HttpStatus.OK);
}

}
