package shop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages="shop.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(){
        return "error";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to repos
    }

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,
            reason = "Not acceptable values")
    @ExceptionHandler(NullPointerException.class)
    public void NullExceptionHandler() {
        // Nothing to repos
    }

}
