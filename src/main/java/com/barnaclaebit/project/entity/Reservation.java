package com.barnaclaebit.project.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reservation")
public class Reservation {

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
    private int maxDays;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public int getmaxOccupants() {
        return maxOccupants;
    }

    public void setmaxOccupants(int maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

    public boolean isInMaintenance() {
        return inMaintenance;
    }

    public void setInMaintenance(boolean inMaintenance) {
        this.inMaintenance = inMaintenance;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + (isReserved ? 1231 : 1237);
        result = prime * result + maxOccupants;
        result = prime * result + (inMaintenance ? 1231 : 1237);
        result = prime * result + maxDays;
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
        Reservation other = (Reservation) obj;
        if (id != other.id)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (isReserved != other.isReserved)
            return false;
        if (maxOccupants != other.maxOccupants)
            return false;
        if (inMaintenance != other.inMaintenance)
            return false;
        if (maxDays != other.maxDays)
            return false;
        return true;
    }

}
