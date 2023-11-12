package com.argenbet.app.restfullAPIArgenbet.Persistence.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String dni;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String gender;
    @Column
    private Double balance;
    @Column
    private Double betBalance;
    @Column
    private Date brithDate;
    @Column
    private String password;
}
