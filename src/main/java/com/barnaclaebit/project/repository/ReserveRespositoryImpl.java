package com.barnaclaebit.project.repository;

import com.barnaclaebit.project.entity.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReserveRespositoryImpl implements ReserveRepository {

    @Autowired
    private EntityManager entityManager;


    @Transactional
    @Override
    public List<Reserve> getReserveByContinent(Continent continent) {

//        Query query = entityManager.createQuery("SELECT * FROM Reserve " +
//                "INNER JOIN City ON City.id = Reserve.City.id " +
//                "INNER JOIN State ON State.id = City.State.id " +
//                "INNER JOIN Country ON Country.id = State.Country.id " +
//                "INNER JOIN Continent ON Continent.id = Country.Continent.id "
//                );
//        query.setParameter((int) continent.getId(), continent);

//        return query.getResultList();
        return null;
    }

    @Override
    public List<Reserve> getReserveByState(State state) {
        return null;
    }

    @Override
    public List<Reserve> getReserveByCity(City city) {
        return null;
    }

    @Override
    public List<Reserve> getReserveByCountry(Country country) {
        return null;
    }
}
