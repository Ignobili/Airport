package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Airport doesn't support landing of this plane")

public class AircraftNotAllowedException extends RuntimeException {
}
