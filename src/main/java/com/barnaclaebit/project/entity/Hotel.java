package com.barnaclaebit.project.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Hotel {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String otherInformation;
    private Address address;
    private Date since;
    private boolean isActive;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((otherInformation == null) ? 0 : otherInformation.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((since == null) ? 0 : since.hashCode());
        result = prime * result + (isActive ? 1231 : 1237);
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
        Hotel other = (Hotel) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (otherInformation == null) {
            if (other.otherInformation != null)
                return false;
        } else if (!otherInformation.equals(other.otherInformation))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (since == null) {
            if (other.since != null)
                return false;
        } else if (!since.equals(other.since))
            return false;
        if (isActive != other.isActive)
            return false;
        return true;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOtherInformation() {
        return otherInformation;
    }
    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Date getSince() {
        return since;
    }
    public void setSince(Date since) {
        this.since = since;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    

    
}
