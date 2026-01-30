package eira.reportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import eira.reportservice.fonts.FontInstaller;

@SpringBootApplication
public class EiraReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EiraReportServiceApplication.class, args);
		//FontInstaller.installFont();
	}

}
