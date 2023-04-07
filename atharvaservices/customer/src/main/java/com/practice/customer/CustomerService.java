package com.practice.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .build();

        //todo: check if email is valid
        //todo: check if email not taken
        //todo: store customer in db
        customerRepository.saveAndFlush(customer);
        //todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("FRAUDSTER");
        }

        //todo: send notification

    }
}
