package com.rcbrasileiro.demosso.web.controller.dto;

public class AcordoLenienciaDto {

	private String cnpj;

	private String dataFimAcordo;

	private String dataInicioAcordo;

	private String id;

	private String nomeEmpresa;

	private String nomeFantasia;

	private String orgaoResponsavel;

	private String quantidade;

	private String situacaoAcordo;

	private String ufEmpresa;

	public AcordoLenienciaDto() {
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDataFimAcordo() {
		return dataFimAcordo;
	}

	public void setDataFimAcordo(String dataFimAcordo) {
		this.dataFimAcordo = dataFimAcordo;
	}

	public String getDataInicioAcordo() {
		return dataInicioAcordo;
	}

	public void setDataInicioAcordo(String dataInicioAcordo) {
		this.dataInicioAcordo = dataInicioAcordo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getOrgaoResponsavel() {
		return orgaoResponsavel;
	}

	public void setOrgaoResponsavel(String orgaoResponsavel) {
		this.orgaoResponsavel = orgaoResponsavel;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getSituacaoAcordo() {
		return situacaoAcordo;
	}

	public void setSituacaoAcordo(String situacaoAcordo) {
		this.situacaoAcordo = situacaoAcordo;
	}

	public String getUfEmpresa() {
		return ufEmpresa;
	}

	public void setUfEmpresa(String ufEmpresa) {
		this.ufEmpresa = ufEmpresa;
	}
}