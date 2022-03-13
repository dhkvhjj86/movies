package com.cg.mtb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieTicketBookingFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingFinalApplication.class, args);
	}
	
	@Bean
    RestTemplate getRs()
    {
        RestTemplate rt=new RestTemplate();
        return rt;
    }

}
