package br.com.workshop.demo.camelconsumerproducer.infrastructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class IntegrationException extends RuntimeException {

    @Getter
    private final HttpStatus httpStatus;

    @Getter
    private final String detailMessage;


    public IntegrationException(String message, String detailMessage, HttpStatus httpStatus) {
        super(message);
        this.detailMessage = detailMessage;
        this.httpStatus = httpStatus;
    }

}
