package com.practice.fraud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    @Autowired
    FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isfraudster(@PathVariable("customerId") Integer customerId){
        return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
    }

}
