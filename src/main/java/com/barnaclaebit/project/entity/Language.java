package com.barnaclaebit.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Language {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String iso_639_1;
    private String iso_639_2;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((iso_639_1 == null) ? 0 : iso_639_1.hashCode());
        result = prime * result + ((iso_639_2 == null) ? 0 : iso_639_2.hashCode());
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
        Language other = (Language) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (iso_639_1 == null) {
            if (other.iso_639_1 != null)
                return false;
        } else if (!iso_639_1.equals(other.iso_639_1))
            return false;
        if (iso_639_2 == null) {
            if (other.iso_639_2 != null)
                return false;
        } else if (!iso_639_2.equals(other.iso_639_2))
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
    public String getIso_639_1() {
        return iso_639_1;
    }
    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }
    public String getIso_639_2() {
        return iso_639_2;
    }
    public void setIso_639_2(String iso_639_2) {
        this.iso_639_2 = iso_639_2;
    }


    
    
}
