package com.barnaclaebit.project.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="tb_contact")
@Getter
@Setter
@EqualsAndHashCode
public class Contact {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private long id;
    @OneToMany
    @PrimaryKeyJoinColumn()
    private List<Address> address;
    @Column(name = "cl_phone_number")
    private String phoneNumber;
    @Column(name = "cl_email")
    private String email;
    @Column(name = "cl_last_update")
    private Date lastUpdate;


}
