package com.barnaclaebit.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private District disctrict;
    private String street;
    private int number;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((disctrict == null) ? 0 : disctrict.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + number;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (id != other.id)
            return false;
        if (disctrict == null) {
            if (other.disctrict != null)
                return false;
        } else if (!disctrict.equals(other.disctrict))
            return false;
        if (street == null) {
            if (other.street != null)
                return false;
        } else if (!street.equals(other.street))
            return false;
        if (number != other.number)
            return false;
        return true;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public District getDisctrict() {
        return disctrict;
    }
    public void setDisctrict(District disctrict) {
        this.disctrict = disctrict;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    

    
}
