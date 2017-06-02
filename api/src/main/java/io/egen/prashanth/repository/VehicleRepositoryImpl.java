package io.egen.prashanth.repository;

import io.egen.prashanth.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ppeddabbu on 5/30/2017.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void upsert(List<Vehicle> vehicles) {

       // List<Vehicle> vehicleList = vehicles.getVehicles();

        for(Vehicle v: vehicles){
            em.merge(v);
        }
    }



}
