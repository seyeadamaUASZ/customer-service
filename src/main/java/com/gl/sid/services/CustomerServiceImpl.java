package com.gl.sid.services;

import com.gl.sid.dto.CustomerRequestDTO;
import com.gl.sid.dto.CustomerResponseDTO;
import com.gl.sid.entities.Customer;
import com.gl.sid.mappers.CustomerMapper;
import com.gl.sid.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer savedCustomer = customerRepository.save(customerMapper.customerRequestDTOCustomer(customerRequestDTO));
        return customerMapper.customerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer= customerMapper.customerRequestDTOCustomer(customerRequestDTO);
        Customer customUpdate = customerRepository.saveAndFlush(customer);
        return customerMapper.customerToCustomerResponseDTO(customUpdate);
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS=
                customers.stream().map(cust->customerMapper.customerToCustomerResponseDTO(cust))
                .collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
