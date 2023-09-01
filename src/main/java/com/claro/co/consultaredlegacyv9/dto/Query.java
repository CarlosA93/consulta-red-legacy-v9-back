package com.claro.co.consultaredlegacyv9.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Query {
    
    @NotNull
	@Valid
	private Line line;

	@NotEmpty(message = "Please provide a value for legacys")
	private String[] legacys;

    public String[] getLegacys() {
		return legacys;
	}

	public void setLegacys(String[] legacys) {
		this.legacys = legacys;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}
}
