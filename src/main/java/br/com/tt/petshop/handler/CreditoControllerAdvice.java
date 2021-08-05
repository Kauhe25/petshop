package br.com.tt.petshop.handler;

import br.com.tt.petshop.exception.CreditoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CreditoControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorInfo trataErro(CreditoException e){
        log.info("Erro no crédito", e);
        return new ErrorInfo("erro_credito", e.getMessage());
    }

}