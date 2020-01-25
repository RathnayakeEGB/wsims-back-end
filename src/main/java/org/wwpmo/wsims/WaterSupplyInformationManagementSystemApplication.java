package org.wwpmo.wsims;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaterSupplyInformationManagementSystemApplication {
	private static final Logger log = LoggerFactory.getLogger(WaterSupplyInformationManagementSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WaterSupplyInformationManagementSystemApplication.class, args);
		log.info("{_Application Start Succesfully................}");
	}

}
