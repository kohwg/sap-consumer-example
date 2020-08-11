package com.example.consumingwebservice.business.ui;

import com.example.consumingwebservice.business.application.SoapRequestService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SoapRequestController {

    @Autowired
    private SoapRequestService soapRequestService;

    @PostMapping(path="/sap")
    public String postCurrency(@RequestBody String lastname, String firstname, String title){
        return soapRequestService.getSentence(lastname, firstname, title).getEPNAME();
    }
    @PostMapping(path="/sap2")
    public String postCurrency(@RequestBody Map<String,Object> body){
        String lastname = (String) body.get("lastName");
        String firstname = (String) body.get("firstName");
        String title = (String) body.get("title");
        return soapRequestService.getSentence(lastname, firstname, title).getEPNAME();
    }
}
