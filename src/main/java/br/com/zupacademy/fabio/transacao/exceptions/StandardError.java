package br.com.zupacademy.fabio.transacao.exceptions;

import java.time.LocalDateTime;

public class StandardError {

    private final LocalDateTime timeError;
    private final Integer statusCode;
    private final String status;
    private final String details;

    public StandardError(LocalDateTime timeError, Integer statusCode, String status, String details) {
        this.timeError = timeError;
        this.statusCode = statusCode;
        this.status = status;
        this.details = details;
    }

    public LocalDateTime getTimeError() {
        return timeError;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }
}
