package com.example.resume.controllerAdvice;

import com.example.resume.controller.PersonalInfoController;
import com.example.resume.dto.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class PersonalInfoControllerAdvice {

    private final MessageSource messageSource;

    private ErrorDto makeErrorResponse(FieldError error){
        String field = error.getField();
        String message = getErrorMessage(error);

        return ErrorDto.builder()
                .key(field)
                .message(message)
                .build();
    }

    private String getErrorMessage(FieldError error){
        for(String code : Objects.requireNonNull(error.getCodes())){
            try{
                return messageSource.getMessage(code, error.getArguments(), Locale.KOREA );
            } catch (NoSuchMessageException e){
                //메시지가 없을 때의 처리
            } catch (NullPointerException e) {
                //errorCode 가 없을 때의 처리..?
            }
        }

        return error.getDefaultMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> test(MethodArgumentNotValidException e){

        List<ErrorDto> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach((error)->{
            errors.add(makeErrorResponse(error));
        });

        return ResponseEntity.badRequest().body(errors);
    }

}
