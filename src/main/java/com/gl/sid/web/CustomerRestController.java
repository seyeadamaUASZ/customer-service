package com.gl.sid.web;

import com.gl.sid.dto.CustomerRequestDTO;
import com.gl.sid.dto.CustomerResponseDTO;
import com.gl.sid.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private CustomerService customerService;


    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping("/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }
    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
       return  customerService.getCustomer(id);
    }
}
