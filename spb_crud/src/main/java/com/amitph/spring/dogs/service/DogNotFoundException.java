package com.amitph.spring.dogs.service;

public class DogNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public DogNotFoundException(String message) {
        super(message);
    }
}