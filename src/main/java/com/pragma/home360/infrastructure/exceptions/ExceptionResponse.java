package com.pragma.home360.infrastructure.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timeStamp) {
}
