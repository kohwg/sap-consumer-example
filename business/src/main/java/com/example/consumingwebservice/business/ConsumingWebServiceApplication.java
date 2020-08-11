package com.example.consumingwebservice.business;

import com.example.consumingwebservice.business.application.SoapRequestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.example.consumingwebservice")
public class ConsumingWebServiceApplication extends SpringBootServletInitializer {

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ConsumingWebServiceApplication.class);
    }

	@Autowired
	private SoapRequestService soapRequestService;
	private static final Logger log = LoggerFactory.getLogger(ConsumingWebServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}
}
