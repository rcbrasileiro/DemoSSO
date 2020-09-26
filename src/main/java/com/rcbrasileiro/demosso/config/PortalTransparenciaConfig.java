package com.rcbrasileiro.demosso.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortalTransparenciaConfig {
	
	@Value("${portalTransparencia.api:71b0aea3225732b569c74a440bbcde0b}")
	private String keyAPI;

	public String getKeyAPI() {
		return keyAPI;
	}

	public void setKeyAPI(String keyAPI) {
		this.keyAPI = keyAPI;
	}
}