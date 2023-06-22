package com.fund.wise.api.fundwise;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "FundWiseAPI", version = "1", description = "API desenvolvida para gerenciamento de investimentos"))
public class FundwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundwiseApplication.class, args);
	}

}
