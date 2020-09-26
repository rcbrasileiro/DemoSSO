package com.rcbrasileiro.demosso.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FrontEndConfig {
	
	@Value("${frontend.url:http://localhost:8080}")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
}