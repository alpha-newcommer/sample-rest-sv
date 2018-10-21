package com.example.samplerestsv.app;

import java.io.Serializable;

public class SampleResource implements Serializable {

	/**
	 * sid
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
