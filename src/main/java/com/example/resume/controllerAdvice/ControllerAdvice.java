package com.example.resume.controllerAdvice;

import com.example.resume.dto.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ControllerAdvice {

    private final MessageSource messageSource;

    private void classifyErrors(Map<String, String> errors, FieldError error){

        String field = error.getField();
        String newMessage = getErrorMessage(error);

        String existedMessage = errors.get(field);
        if(existedMessage != null) {
            newMessage = existedMessage+","+newMessage;
        }
        errors.put(field, newMessage);
    }

    private String getErrorMessage(FieldError error){
        for(String code : Objects.requireNonNull(error.getCodes())){
            try{
                return messageSource.getMessage(code, error.getArguments(), Locale.KOREA);
            } catch (NoSuchMessageException e){
                //메시지가 없을 때의 처리
            } catch (NullPointerException e) {
                //errorCode 가 없을 때의 처리..?
            }
        }

        return error.getDefaultMessage();
    }

    private List<ErrorDto> makeErrorResponse(Map<String, String> errors){

        List<ErrorDto> errorResponse = new ArrayList<>();

        for(String field : errors.keySet()){
            errorResponse.add(new ErrorDto(field, errors.get(field)));
        }

        return errorResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> exceptionHandler(MethodArgumentNotValidException e){

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((error)->{
            classifyErrors(errors, error);
        });

        List<ErrorDto> errorResponse = makeErrorResponse(errors);

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
