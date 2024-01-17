package com.SefaTas.KuaforRandevu;

import com.SefaTas.KuaforRandevu.Entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class KuaforRandevuApplication {

	public static void main(String[] args) {
		SpringApplication.run(KuaforRandevuApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner userCreator(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for(var i = 1; i <= 25; i++){
					User user = new User();
					user.setFirstName("user" + i);
					user.setLastName("user" + i);
					user.setPhone("user" + i);
					user.setEmail("user" + i + "@gmail.com");
					user.setPassword("P4ssword" + i);
				}
			}
		};
	}

}
