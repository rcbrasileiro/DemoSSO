package com.rcbrasileiro.demosso.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcbrasileiro.demosso.config.PortalTransparenciaConfig;
import com.rcbrasileiro.demosso.remote.IPortalTransparenciaService;
import com.rcbrasileiro.demosso.web.controller.dto.AcordoLenienciaDto;

@RestController
public class Controller {

	@Autowired
	private PortalTransparenciaConfig portalTransparenciaConfig;

	@Autowired
	private IPortalTransparenciaService portalTransparenciaService;

	/*
	 * @GetMapping("/") public ResponseEntity<List<AcordoLenienciaDto>> helloWord()
	 * { List<AcordoLenienciaDto> acordos = portalTransparenciaService
	 * .listAcordosLenciencia(portalTransparenciaConfig.getKeyAPI()); return
	 * ResponseEntity.ok(acordos); }
	 */
	
	@GetMapping("/")
	 public Principal user(Principal principal) {
	        return principal;
	    }

	@GetMapping("/restricted")
	public String restricted() {
		return "to see this text you need to be logged in!";
	}
}
