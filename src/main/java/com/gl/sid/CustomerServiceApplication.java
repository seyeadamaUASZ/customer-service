package com.gl.sid;

import com.gl.sid.dto.CustomerRequestDTO;
import com.gl.sid.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01","Adama","adama@gmail.com"));
            customerService.save(new CustomerRequestDTO("C02","OpenLab","openLab@contact.com"));

        };
    }

}
