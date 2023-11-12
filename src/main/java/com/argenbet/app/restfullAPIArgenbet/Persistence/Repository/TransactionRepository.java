package com.argenbet.app.restfullAPIArgenbet.Persistence.Repository;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query(value = "SELECT * FROM transaction WHERE user_id=:id",
                nativeQuery = true)
    public List<Transaction> findByUserId(@Param("id")Long id);
}
