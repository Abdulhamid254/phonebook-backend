package com.abdul.phonebook;

import com.abdul.phonebook.model.Phonebook;
import com.abdul.phonebook.repo.PhonebookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@SpringBootApplication
public class PhonebookApplication {

	public static void main(String[] args) {

		SpringApplication.run(PhonebookApplication.class, args);
	}


//	@Bean
//	CommandLineRunner run(PhonebookRepo phonebookRepo) {
//		return args -> {
//			phonebookRepo.save(new Phonebook(null,"Josep","Begestain","pep92@hotmail.com","0734616169","nrk-1236","PepB"));
//			phonebookRepo.save(new Phonebook(null,"Peter","Cesc","Cesc@outlook.com","0782828595","nrb-7273","PCesc"));
//			phonebookRepo.save(new Phonebook(null,"Carlo","Ancellotti","carlo90@gmail.com","0764328280","ksm-7283","Carlo"));
//			phonebookRepo.save(new Phonebook(null,"Musa","Fuadi","moosa2@gmail.com","0797428285","eld-2435","Moosa"));
//
//		};
//
//	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
