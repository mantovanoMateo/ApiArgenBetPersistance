package com.argenbet.app.restfullAPIArgenbet.Service;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.Bet;
import com.argenbet.app.restfullAPIArgenbet.Persistence.Repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService {

    @Autowired
    private final BetRepository repository;

    public BetService(BetRepository repository) {
        this.repository = repository;
    }
    public Bet createBet(Bet bet){
        return this.repository.save(bet);
    }

    public List<Bet> findAll(){
        return this.repository.findAll();
    }

    public void delete(Long id){
        Optional<Bet> betOptional=this.repository.findById(id);
        if(betOptional.isEmpty()){

        }
        this.repository.deleteById(id);
    }

    public void updateBet(Long id, Bet bet){
        Bet updatedBet=repository.findById(id).get();
        updatedBet.setBetValue(bet.getBetValue());
        repository.save(updatedBet);
    }

    public List<Bet> findPendingBets(Long id){
        return this.repository.findPendingBets(id);
    }

    public List<Bet> findByFixture(Long id){
        return this.repository.findByFixtureId(id);
    }

    public List<Bet> findByUserId(Long id){
        return this.repository.findByUserId(id);
    }

    public Long getLastId(){return this.repository.getLastId();}

    //faltan listar las que son del propio usaurio y elimnar por ID
}
