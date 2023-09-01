package com.claro.co.consultaredlegacyv9.dto;

import javax.validation.constraints.NotEmpty;

public class Url {

    @NotEmpty(message = "Please provide a value for propertie")
	private String propertie;
	
    @NotEmpty(message = "Please provide a value for value")
	private String value;
	
    private String error;
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPropertie() {
		return propertie;
	}

	public void setPropertie(String propertie) {
		this.propertie = propertie;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
