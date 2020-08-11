package com.example.consumingwebservice.business.application;

import com.example.consumingwebservice.business.wsdl.YFMAWSWS01;
import com.example.consumingwebservice.business.wsdl.YFMAWSWS01Response;
import com.example.consumingwebservice.domain.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CurrencyService currencyService;

    public YFMAWSWS01Response getSentence(String lastName, String firstName, String title){
        return currencyService.getSentence(lastName, firstName, title);
    }
}
