package com.argenbet.app.restfullAPIArgenbet.Controller;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.Transaction;
import com.argenbet.app.restfullAPIArgenbet.Service.TransactionService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return this.transactionService.createTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> findAll(){
        return this.transactionService.findAll();
    }

    @GetMapping("/user/{id}")
    public List<Transaction> findByUserId(@PathVariable("id")Long id){
        return this.transactionService.findByUserId(id);
    }
}
