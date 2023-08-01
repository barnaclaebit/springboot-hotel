package com.barnaclaebit.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_language")
@Getter
@Setter
@EqualsAndHashCode
public class Language {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private long id;
    @Column(name = "cl_name")
    private String name;
    @Column(name = "cl_iso_639_1")
    private String iso_639_1;
    @Column(name = "cl_iso_639_2")
    private String iso_639_2;
    


    
    
}
