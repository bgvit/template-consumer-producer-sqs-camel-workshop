package br.com.workshop.demo.camelconsumerproducer.infrastructure.exception;

import org.springframework.http.HttpStatus;

public class CryptoCurrencyInformationException extends IntegrationException{

    public CryptoCurrencyInformationException(String message, String detailMessage, HttpStatus httpStatus) {
        super(message, detailMessage, httpStatus);
    }
}
