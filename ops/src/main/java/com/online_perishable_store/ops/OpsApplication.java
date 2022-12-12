package com.online_perishable_store.ops;

import com.online_perishable_store.user.TryBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
@Controller

@SpringBootApplication(scanBasePackages={"com.online_perishable_store.user", "com.online_perishable_store.ops"})
@EnableJpaRepositories("com.online_perishable_store.*")
@EntityScan("com.online_perishable_store.*")
@ComponentScan("com.online_perishable_store.*")
public class OpsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OpsApplication.class, args);
		System.out.println("try bean : "+new TryBean());
	}
	
}
