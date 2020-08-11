
package com.example.consumingwebservice.business.config;

import com.example.consumingwebservice.domain.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

// add this line due to SOAP12
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@Configuration
public class CountryConfiguration {

	@Autowired
	private CurrencyService currencyService;

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
	public CurrencyService currencyService(Jaxb2Marshaller marshaller, SaajSoapMessageFactory messageFactory) {
		// localTest 용
		currencyService.setDefaultUri("https://6q6j808jnf.execute-api.ap-northeast-2.amazonaws.com/DEV/sapendpoint");
		// private Endpoint 용
//		currencyService.setDefaultUri("https://ie2szfste0.execute-api.ap-northeast-2.amazonaws.com/DEV/sapendpoint");
		currencyService.setMarshaller(marshaller);
		currencyService.setMarshaller(marshaller);
		currencyService.setUnmarshaller(marshaller);
		// add this line due to SOAP12
		currencyService.setMessageFactory(messageFactory);
		return currencyService;
	}

}
