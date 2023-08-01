package com.barnaclaebit.project.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_country")
@Getter
@Setter
@EqualsAndHashCode
public class Country {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private long id;
    @Column(name = "cl_name")
    private String name;
    @OneToOne
    @PrimaryKeyJoinColumn()
    private Currency currency;
    @OneToOne
    @PrimaryKeyJoinColumn()
    private Language Language;
    @OneToMany
    @PrimaryKeyJoinColumn()
    private List<Continent> continent;

    public boolean isTranscontinental(){
        return continent != null && continent.size() > 0;
    }


    
}
