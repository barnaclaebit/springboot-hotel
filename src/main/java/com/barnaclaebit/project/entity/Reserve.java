package com.barnaclaebit.project.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_reserve")
@Getter
@Setter
@EqualsAndHashCode
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private long id;
    @Column(name = "cl_date")
    private Date date;
    @Column(name = "cl_value")
    private BigDecimal value;
    @Column(name = "cl_is_reserved")
    private boolean isReserved;
    @Column(name = "cl_max_occupants")
    private int maxOccupants;
    @Column(name = "cl_in_maintenance")
    private boolean inMaintenance;
    @Column(name = "cl_max_days")
    private int maxDays;
    @OneToOne
    @PrimaryKeyJoinColumn()
    private City city;

}
