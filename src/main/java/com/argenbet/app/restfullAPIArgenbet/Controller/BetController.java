package com.argenbet.app.restfullAPIArgenbet.Controller;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.Bet;
import com.argenbet.app.restfullAPIArgenbet.Service.BetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/bets")
public class BetController {
    private final BetService betService;

    public BetController(BetService betService) {
        this.betService = betService;
    }
    @PostMapping
    public Bet createBet(@RequestBody Bet bet){
        return this.betService.createBet(bet);
    }
    @GetMapping
    public List<Bet> findALl(){
        return this.betService.findAll();
    }
    @GetMapping("/user/{id}")
    public List<Bet> findByUserId(@PathVariable("id")Long id){
        return this.betService.findByUserId(id);
    }
    @GetMapping("/fixture/{id}")
    public List<Bet> findByFixtureId(@PathVariable("id")Long id){
        return this.betService.findByFixture(id);
    }
    @GetMapping("/pending/{id}")
    public List<Bet> getPendingBets(@PathVariable("id")Long id){
        return this.betService.findPendingBets(id);
    }
    @GetMapping("/lastId")
    public Long getLastId(){return this.betService.getLastId();}
    @PutMapping("/update/{id}")
    public String updateBet(@PathVariable("id") Long id,@RequestBody Bet bet){
        this.betService.updateBet(id,bet);
        return "updatedBet";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBet(@PathVariable("id") Long id){
        this.betService.delete(id);
        return "deletedBet";
    }
}
