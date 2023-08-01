package com.barnaclaebit.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_address")
@Getter
@Setter
@EqualsAndHashCode
public class Address {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private long id;
    @OneToOne
    @PrimaryKeyJoinColumn
    private District district;
    @Column(name = "cl_street")
    private String street;
    @Column(name = "cl_number")
    private int number;


}
