package org.sst.productservicesst.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.sst.productservicesst.DTOs.ExceptionDTO;
import org.sst.productservicesst.exceptions.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithematicException(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolution("This is Arithmatic Exception");

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBoundException(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Something went wrong");
        exceptionDTO.setResolution("This is Array Index Out Of Bound Exception");

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Invalid Product Id" + productNotFoundException.getId()+ "passed");
        exceptionDTO.setResolution("This is Product Not Found Exception");

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

}
