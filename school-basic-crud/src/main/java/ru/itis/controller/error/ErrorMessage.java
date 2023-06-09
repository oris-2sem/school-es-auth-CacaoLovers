package ru.itis.controller.error;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ErrorMessage {
    private String message;
    private Integer status;
}
