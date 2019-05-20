package pl.tlis.eurekaproducerpcf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@EnableDiscoveryClient
public class EurekaProducerPcfApplication {
	private static final Logger logger = LoggerFactory.getLogger(EurekaProducerPcfApplication.class);
	@Bean
	@Profile(value = "cloud")
	public Cloud cloud() {
		Cloud cloud =  new CloudFactory().getCloud();
		logger.info(cloud.getCloudProperties().toString());
		return cloud;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaProducerPcfApplication.class, args);
	}

}
