package net.ahramionok;

import net.ahramionok.security.SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@CrossOrigin
public class SiteBuilderApplication {
	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
		return new SecurityConfiguration();
	}
	public static void main(String[] args) {
		SpringApplication.run(SiteBuilderApplication.class, args);
	}
}
