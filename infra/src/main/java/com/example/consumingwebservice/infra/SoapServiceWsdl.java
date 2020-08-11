package com.example.consumingwebservice.infra;

import com.example.consumingwebservice.domain.soapService;
import com.example.consumingwebservice.business.wsdl.YFMAWSWS01;
import com.example.consumingwebservice.business.wsdl.YFMAWSWS01Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class SoapServiceWsdl extends soapService {

    private static final Logger log = LoggerFactory.getLogger(SoapServiceWsdl.class);

    public YFMAWSWS01Response getSentence(String lastName, String firstName, String title){
        YFMAWSWS01 request = new YFMAWSWS01();
        request.setIPFIRSTNAME(firstName);
        request.setIPLASTNAME(lastName);
        request.setIPTITLE(title);

        log.info("Requesting info " + title + lastName + firstName);

        YFMAWSWS01Response response = (YFMAWSWS01Response) getWebServiceTemplate()
                //localtest 용
                .marshalSendAndReceive("https://6q6j808jnf.execute-api.ap-northeast-2.amazonaws.com/DEV/sapendpoint", request,
                //privateEndpoint 용
//                .marshalSendAndReceive("https://ie2szfste0.execute-api.ap-northeast-2.amazonaws.com/DEV/sapendpoint", request,
                        new SoapActionCallback(
                                "urn:sap-com:document:sap:rfc:functions:YWS_AWS_WS01:YFM_AWS_WS01Request"));
        return response;
    }
}
