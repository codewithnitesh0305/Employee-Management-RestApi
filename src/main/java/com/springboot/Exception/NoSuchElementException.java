package com.springboot.Exception;

import java.io.Serial;

public class NoSuchElementException extends RuntimeException{

	@Serial
	private static final long serialVersionUID = 4119870119244302477L;
	public NoSuchElementException(String message) {
		super(message);
	}

}
