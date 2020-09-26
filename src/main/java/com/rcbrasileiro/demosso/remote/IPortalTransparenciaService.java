package com.rcbrasileiro.demosso.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.rcbrasileiro.demosso.web.controller.dto.AcordoLenienciaDto;

@FeignClient(url="http://www.portaltransparencia.gov.br", name="http://www.portaltransparencia.gov.br")
public interface IPortalTransparenciaService {

	@GetMapping("api-de-dados/acordos-leniencia")
	List<AcordoLenienciaDto> listAcordosLenciencia(@RequestHeader("chave-api-dados") String api);

	

}
