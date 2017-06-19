//Import Statements
package edu.cmu.bian.controller;

import edu.cmu.bian.model.PmtAddRq.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/*
Business Use Case: This caters to the payment initiation service provider (PISP) requirement of the PSD2.
Objective: The Payment Request Controller provides the end point for the TPP to Access and Initiate a payment.
           It looks up the PNC API Exchange to fill a few additional fields based on the parameters sent by the TPP.
           An IFX Compliant JSON response is built and echoed back.
Created By: CMU BIAN-PNC Capstone Team
Last Update Date: 4/24/2017
*/

@RestController
public class HelloWorldController {
//PUT request for initiating payment
    @GetMapping("/hello")
    public HelloResponse paymentAddRequest() {

        //Return the JSON response
        return new HelloResponse("Hello World!");
    }

}
