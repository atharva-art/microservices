package com.practice.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/vi/customers")
public record CustomerController(CustomerService customerService) {

    @PostMapping("register")
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        log.info(String.valueOf(customerRequest));
        customerService.registerCustomer(customerRequest);
    }

}
