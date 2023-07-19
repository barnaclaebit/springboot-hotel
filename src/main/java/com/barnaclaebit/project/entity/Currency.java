package com.barnaclaebit.project.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Currency {
    
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String majorName;
    private String minorName;
    private String cipher;
    private String minorCipher;
    private BigDecimal value;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMajorName() {
        return majorName;
    }
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    public String getMinorName() {
        return minorName;
    }
    public void setMinorName(String minorName) {
        this.minorName = minorName;
    }
    public String getCipher() {
        return cipher;
    }
    public void setCipher(String cipher) {
        this.cipher = cipher;
    }
    public String getMinorCipher() {
        return minorCipher;
    }
    public void setMinorCipher(String minorCipher) {
        this.minorCipher = minorCipher;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((majorName == null) ? 0 : majorName.hashCode());
        result = prime * result + ((minorName == null) ? 0 : minorName.hashCode());
        result = prime * result + ((cipher == null) ? 0 : cipher.hashCode());
        result = prime * result + ((minorCipher == null) ? 0 : minorCipher.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        Currency other = (Currency) obj;
        if (id != other.id)
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (majorName == null) {
            if (other.majorName != null)
                return false;
        } else if (!majorName.equals(other.majorName))
            return false;
        if (minorName == null) {
            if (other.minorName != null)
                return false;
        } else if (!minorName.equals(other.minorName))
            return false;
        if (cipher == null) {
            if (other.cipher != null)
                return false;
        } else if (!cipher.equals(other.cipher))
            return false;
        if (minorCipher == null) {
            if (other.minorCipher != null)
                return false;
        } else if (!minorCipher.equals(other.minorCipher))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    


    

    
}


