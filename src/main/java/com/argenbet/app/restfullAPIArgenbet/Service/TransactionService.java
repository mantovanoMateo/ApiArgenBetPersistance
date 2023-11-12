package com.argenbet.app.restfullAPIArgenbet.Service;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.Transaction;
import com.argenbet.app.restfullAPIArgenbet.Persistence.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }
    public Transaction createTransaction(Transaction transaction){
        return this.repository.save(transaction);
    }

    public List<Transaction> findAll(){
        return this.repository.findAll();
    }

    public void delete(Long id){
        Optional<Transaction> transactionOptional=this.repository.findById(id);
        if(transactionOptional.isEmpty()){

        }
        this.repository.deleteById(id);
    }

    public List<Transaction> findByUserId(Long id){
        return this.repository.findByUserId(id);
    }

    //faltan listar las que son del propio usaurio y elimnar por ID y update

}
