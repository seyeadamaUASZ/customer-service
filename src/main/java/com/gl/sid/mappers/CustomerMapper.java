package com.gl.sid.mappers;

import com.gl.sid.dto.CustomerRequestDTO;
import com.gl.sid.dto.CustomerResponseDTO;
import com.gl.sid.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOCustomer(CustomerRequestDTO customerRequestDTO);

}
