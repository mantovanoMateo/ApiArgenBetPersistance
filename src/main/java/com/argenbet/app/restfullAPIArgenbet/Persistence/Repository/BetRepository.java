package com.argenbet.app.restfullAPIArgenbet.Persistence.Repository;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet,Long> {
    @Query(value = "SELECT * FROM bet WHERE user_id=:id",
            nativeQuery=true)
    public List<Bet> findByUserId(@Param("id")Long id);
    @Query(value = "SELECT * FROM bet WHERE fixture_id =:id",
            nativeQuery=true)
    public List<Bet> findByFixtureId(@Param("id")Long id);
    @Query(value = "SELECT * FROM bet WHERE bet_status LIKE 'NS' AND user_id=:id",
            nativeQuery = true)
    public List<Bet> findPendingBets(@Param("id")Long id);

    @Query(value="SELECT id FROM bet ORDER BY id DESC LIMIT 1",
            nativeQuery = true)
    public Long getLastId();
}
