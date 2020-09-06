package com.example.springcloudconfigclient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@ConfigurationProperties
public class ConfigController {
	
	@Value("${msg}")
	String msg;
	
	@Value("${spring.datasource.username}")
	String databaseConnectionUsername;
	
	@Value("${spring.datasource.password}")
	String databaseConnectionPassword;
	
	@Value("${test.property}")
	String testProperty;
	
	@GetMapping("/db-properties")
	public String getPropertyDetails() {
		Map<String, String> dbMap = new HashMap<>();
		dbMap.put("message", msg);
		dbMap.put("username", databaseConnectionUsername);
		dbMap.put("password", databaseConnectionPassword);
		dbMap.put("testProperty", testProperty);
		return dbMap.toString();
	}

}
