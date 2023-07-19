package com.barnaclaebit.project.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class Country {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToOne
    private Currency currency;
    @OneToOne
    private Language Language;
    @OneToMany
    private List<Continent> continent;

    public boolean isTranscontinental(){
        return continent != null ? continent.size() > 0 : false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + ((Language == null) ? 0 : Language.hashCode());
        result = prime * result + ((continent == null) ? 0 : continent.hashCode());
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
        Country other = (Country) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        if (Language == null) {
            if (other.Language != null)
                return false;
        } else if (!Language.equals(other.Language))
            return false;
        if (continent == null) {
            if (other.continent != null)
                return false;
        } else if (!continent.equals(other.continent))
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
    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    public Language getLanguage() {
        return Language;
    }
    public void setLanguage(Language language) {
        Language = language;
    }
    public List<Continent> getContinent() {
        return continent;
    }
    public void setContinent(List<Continent> continent) {
        this.continent = continent;
    }

    

    


    
    
}
