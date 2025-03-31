package kr.co.ipdisk.dundunhsk.apiboard.common;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import kr.co.ipdisk.dundunhsk.apiboard.data.enumSet.ErrorType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private int status;
    private String message;

    @Builder
    private ErrorResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    public static ErrorResponse of(ErrorType errorType){
        return ErrorResponse.builder()
            .status(errorType.getStatus())
            .message(errorType.getMessage())
            .build();
    }

    public static ErrorResponse of(HttpStatus httpStatus, String message){
        return ErrorResponse.builder()
            .status(httpStatus.value())
            .message(message)
            .build();
    }

    public static ErrorResponse of(BindingResult bindingResult){
        String message = "";
        if(bindingResult.hasErrors()){
            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        return ErrorResponse.of(HttpStatus.BAD_REQUEST, message);
    }
}
