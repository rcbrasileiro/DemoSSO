package com.rcbrasileiro.demosso.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcbrasileiro.demosso.config.PortalTransparenciaConfig;
import com.rcbrasileiro.demosso.remote.IPortalTransparenciaService;
import com.rcbrasileiro.demosso.web.controller.dto.AcordoLenienciaDto;

@RestController
@RequestMapping("portal-transparencia")
public class PortalTransparenciaController {

	@Autowired
	private PortalTransparenciaConfig portalTransparenciaConfig;

	@Autowired
	private IPortalTransparenciaService portalTransparenciaService;

	@GetMapping("/acordos-leniencia")
	public ResponseEntity<List<AcordoLenienciaDto>> helloWord() {
		List<AcordoLenienciaDto> acordos = portalTransparenciaService
				.listAcordosLenciencia(portalTransparenciaConfig.getKeyAPI());
		return ResponseEntity.ok(acordos);
	}	
}
