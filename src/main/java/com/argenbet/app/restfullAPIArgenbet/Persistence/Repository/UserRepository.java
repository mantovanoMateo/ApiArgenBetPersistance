package com.argenbet.app.restfullAPIArgenbet.Persistence.Repository;

import com.argenbet.app.restfullAPIArgenbet.Persistence.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM user WHERE email =:email",
            nativeQuery=true)
    public User findByEmail(@Param("email")String mail);
}
