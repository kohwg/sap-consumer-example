package com.example.consumingwebservice.domain;

import com.example.consumingwebservice.business.wsdl.YFMAWSWS01Response;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public abstract class soapService extends WebServiceGatewaySupport {
    abstract public YFMAWSWS01Response getSentence(String lastName, String firstName, String title);
}
