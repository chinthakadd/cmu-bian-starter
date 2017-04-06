package edu.cmu.bian.controller;

import edu.cmu.bian.model.CompositeObject;
import edu.cmu.bian.model.PaymentModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.util.HashMap;
import java.util.Map;


@RestController
public class Dev_1_Controller {

    @PostMapping("/dev1/hello2/{name}")
    public String helloWorld(@PathVariable("name") String name, @RequestParam("size") int height, @RequestBody PaymentModel paymentModel, @RequestHeader("someHeader") int someHeader) {
        return "this is the path param " + name + " and this is a query param " + height + " " + paymentModel.getPayeeAccountNumber() + " " + someHeader ;
    }
}
