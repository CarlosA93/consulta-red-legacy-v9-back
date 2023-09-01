package com.claro.co.consultaredlegacyv9.dto;

import java.util.List;

public class QueryUrl {

    private List<Url> listUrl;
	private String error;

	public QueryUrl() {
		super();
	}

	public QueryUrl(List<Url> listUrl, String error) {
		super();
		this.listUrl = listUrl;
		this.error = error;
	}

	public List<Url> getListUrl() {
		return listUrl;
	}

	public void setListUrl(List<Url> listUrl) {
		this.listUrl = listUrl;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}