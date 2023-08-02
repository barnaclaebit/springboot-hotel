package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReserveRepository{


    public List<Reserve> getReserveByContinent(Continent continent);
    public List<Reserve> getReserveByState(State state);
    public List<Reserve> getReserveByCity(City city);
    public List<Reserve> getReserveByCountry(Country country);

}
