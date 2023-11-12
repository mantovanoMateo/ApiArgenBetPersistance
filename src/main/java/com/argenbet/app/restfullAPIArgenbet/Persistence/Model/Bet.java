package com.argenbet.app.restfullAPIArgenbet.Persistence.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.spi.LocaleNameProvider;

@Data
@Entity
@Table(name="Bet")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long fixtureId;
    @Column
    private String headToHead;
    @Column
    private String type;
    @Column
    private String selection;
    @Column
    private Double betValue;
    @Column
    private Double benefit;
    @Column
    private Long userId;
    @Column
    private String betStatus;

}
