// Initial fork from https://github.com/csupomona-cs480/demo-web-project

package edu.csupomona.cs461;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.csupomona.cs461.data.provider.FSUserManager;
import edu.csupomona.cs461.data.provider.UserManager;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {

	@Bean
	public UserManager userManager() {
        UserManager userManager = new FSUserManager();
        return userManager;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
