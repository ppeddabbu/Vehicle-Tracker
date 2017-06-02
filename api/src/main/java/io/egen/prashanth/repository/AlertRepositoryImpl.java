package io.egen.prashanth.repository;

import io.egen.prashanth.entity.Alert;
import io.egen.prashanth.entity.Reading;
import io.egen.prashanth.entity.TireDimension;
import io.egen.prashanth.entity.Vehicle;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ppeddabbu on 6/1/2017.
 */

@Repository
public class AlertRepositoryImpl implements AlertRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Async
    @Transactional
    public void checkAndCreateAlerts(Reading reading, Vehicle vehicle) {
/* check whether this block is executing in async
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        TireDimension td = reading.getTires();

        //async
        //check rule1: engineRpm > readlineRpm, Priority: HIGH
        if( (reading.getEngineRpm()) > (vehicle.getRedlineRpm())){
            Alert alert = new Alert();
            alert.setVin(vehicle.getVin());
            alert.setTimeStamp(reading.getTimestamp());

            alert.setMessage("Engine RPM exceeded RedLine RPM");
            alert.setPriority("HIGH");
            em.persist(alert);
        }
        //check rule2: fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM
        if(reading.getFuelVolume() < (vehicle.getMaxFuelVolume()/10) ){
            Alert alert = new Alert();
            alert.setVin(vehicle.getVin());
            alert.setTimeStamp(reading.getTimestamp());

            alert.setMessage("Low fuel in the tank");
            alert.setPriority("MEDIUM");
            em.persist(alert);
        }
        //Rule3: tire pressure of any tire < 32psi || > 36psi , Priority: LOW
        if(td.getFrontRight() < 32 || td.getFrontRight() > 36){
            Alert alert = new Alert();
            alert.setVin(vehicle.getVin());
            alert.setTimeStamp(reading.getTimestamp());

            if(td.getFrontRight() < 32)
                alert.setMessage("Front right tire low pressure");
            else
                alert.setMessage("Front right tire high pressure");
            alert.setPriority("LOW");
            em.persist(alert);
        }
        //Rule4: engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW
        if(reading.isEngineCoolantLow() || reading.isCheckEngineLightOn() ) {
            Alert alert = new Alert();
            alert.setVin(vehicle.getVin());
            alert.setTimeStamp(reading.getTimestamp());

            if (reading.isEngineCoolantLow())
                alert.setMessage("Engine coolant is low");
            else
                alert.setMessage("Engine Lights are on");
            alert.setPriority("LOW");
            em.persist(alert);
        }
    }
}
