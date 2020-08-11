
package com.example.consumingwebservice.business.config;

import com.example.consumingwebservice.domain.soapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

// add this line due to SOAP12
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@Configuration
public class SoapRequestConfiguration {

	@Autowired
	private soapService soapService;

	// add this line due to SOAP12
	@Bean
	public SaajSoapMessageFactory messageFactory() {
		SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
		messageFactory.setSoapVersion(SoapVersion.SOAP_12);
		return messageFactory;
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.example.consumingwebservice.business.wsdl");
		return marshaller;
	}

	@Bean
	public soapService soapService(Jaxb2Marshaller marshaller, SaajSoapMessageFactory messageFactory) {
		// localTest 용
		soapService.setDefaultUri("https://6q6j808jnf.execute-api.ap-northeast-2.amazonaws.com/DEV/sapendpoint");
		// private Endpoint 용
//		currencyService.setDefaultUri("https://ie2szfste0.execute-api.ap-northeast-2.amazonaws.com/DEV/sapendpoint");
		soapService.setMarshaller(marshaller);
		soapService.setMarshaller(marshaller);
		soapService.setUnmarshaller(marshaller);
		// add this line due to SOAP12
		soapService.setMessageFactory(messageFactory);
		return soapService;
	}

}
