package io.egen.prashanth.repository;

import io.egen.prashanth.entity.Reading;
import io.egen.prashanth.entity.TireDimension;
import io.egen.prashanth.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ppeddabbu on 5/31/2017.
 */

/*
Rule: engineRpm > readlineRpm, Priority: HIGH
Rule: fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM
Rule: tire pressure of any tire < 32psi || > 36psi , Priority: LOW
Rule: engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW
 */

@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager em;


    @Override
    public Reading create(Reading reading) {

        TireDimension td = reading.getTires();
        td.setReadingID(reading.getReadingId()); // set vin in TireDimension table
        em.persist(td);
        //set back it in reading
        reading.setTires(td);
        em.persist(reading);

        return reading;
    }

    @Override
    public Vehicle findVehicle(String vehicleId) {
        return em.find(Vehicle.class, vehicleId);
    }
}
