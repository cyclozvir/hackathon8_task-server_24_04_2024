package org.yaremax.hackathon8_task_24_04_2024.exceptions;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Builder
public record ApiException (
        String message,
        HttpStatus httpStatus,
        ZonedDateTime timeStamp) {
}
