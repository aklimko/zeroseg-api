package pl.adamklimko.zeroseg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ZerosegApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ZerosegApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ZerosegApplication.class);
	}
}
