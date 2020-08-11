package com.example.consumingwebservice.business.application;

import com.example.consumingwebservice.business.wsdl.YFMAWSWS01Response;
import com.example.consumingwebservice.domain.soapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoapRequestService {

    @Autowired
    private soapService soapService;

    public YFMAWSWS01Response getSentence(String lastName, String firstName, String title){
        return soapService.getSentence(lastName, firstName, title);
    }
}
