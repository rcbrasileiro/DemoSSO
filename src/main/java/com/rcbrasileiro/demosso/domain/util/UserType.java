package com.rcbrasileiro.demosso.domain.util;

public enum UserType {

	GOOGLE("GOOGLE"), FACEBOOK("FACEBOOK");

	private String type;

	private UserType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}