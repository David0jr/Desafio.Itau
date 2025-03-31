package desafio.itu.springboot.controller;

import desafio.itu.springboot.dto.TransactionRequest;
import desafio.itu.springboot.model.Transaction;
import desafio.itu.springboot.service.TransactiomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactiomService transactiomService;

    public TransactionController (TransactiomService transactiomService){//Construtor
        this.transactiomService = transactiomService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request){
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <=0){
       return  ResponseEntity.unprocessableEntity().build();
    }
        transactiomService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public  ResponseEntity<Void> clearTransaction(){
        transactiomService.clearTransaction();
        return ResponseEntity.ok().build();
    }

}