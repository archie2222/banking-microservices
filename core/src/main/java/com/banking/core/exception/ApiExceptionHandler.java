package com.banking.core.exception;

import com.banking.core.dto.transaction.WalletTransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleBadRequestException(MethodArgumentNotValidException e, WalletTransactionDto transactionDto) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            errors.put("message", errorMessage);
        });
        transactionDto.setResponseDescription(errors.get("message"));
        return ResponseEntity.ok(transactionDto);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMismatchType(MethodArgumentTypeMismatchException e, WalletTransactionDto transactionDto) {
        log.error(e.getMessage());
        String name = e.getName();
        String type = Objects.requireNonNull(e.getRequiredType()).getSimpleName();
        Object value = e.getValue();
        String message = String.format("%s should be a valid '%s' and you provided '%s'", name, type, value);
        transactionDto.setResponseDescription(message);
        return ResponseEntity.ok(transactionDto);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<Object> handleTransactionException(TransactionException e, WalletTransactionDto transactionDto) {
        log.error(e.getMessage());
        return ResponseEntity.ok(transactionDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleRequestException(Exception e, WalletTransactionDto transactionDto) {
        log.error(e.getMessage());
        return ResponseEntity.ok(transactionDto);
    }

}
