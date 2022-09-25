package com.cartpro.model;

import lombok.Data;

@Data
public class StringResponse {
    private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
    
}