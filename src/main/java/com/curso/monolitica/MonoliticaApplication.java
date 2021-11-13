package com.curso.monolitica;

import com.curso.monolitica.domain.config.Country;
import com.curso.monolitica.domain.human.Person;
import com.curso.monolitica.repository.config.CountryRepository;
import com.curso.monolitica.repository.human.PersonRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
public class MonoliticaApplication implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(MonoliticaApplication.class);

	private final Environment env;

	private final PersonRepository personRepository;
	private final CountryRepository countryRepository;

	public MonoliticaApplication(Environment env, PersonRepository personRepository, CountryRepository countryRepository) {
		this.env = env;
		this.personRepository = personRepository;
		this.countryRepository = countryRepository;
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MonoliticaApplication.class);
		Environment environment = springApplication.run(args).getEnvironment();
		logApplicationStarup(environment);
	}

	private static void logApplicationStarup(Environment env) {
		String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store"))
				.map(key -> "https")
				.orElse("http");
		String serverPort = env.getProperty("server.port");
		String contextPath = Optional
				.ofNullable(env.getProperty("server.servlet.context-path"))
				.filter(StringUtils::isNotBlank)
				.orElse("/");
		String hostAddress = "localhost";

		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using 'localhost' as fallback");
		}

		log.info(
				"\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\t{}://localhost:{}{}\n\t" +
						"External: \t{}://{}:{}{}\n\t" +
						"Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.getActiveProfiles()
		);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Person person = new Person();
		person.setName("Andres");
		person.setLastName("Merida");

		Person person2 = new Person();
		person2.setName("Reynaldo");
		person2.setLastName("Aguilar");

		personRepository.save(person);
		personRepository.save(person2);

		Country country = new Country();
		country.setName("Peru");
		country.setInitials("PER");

		countryRepository.save(country);
	}
}
