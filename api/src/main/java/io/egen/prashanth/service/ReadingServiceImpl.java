package io.egen.prashanth.service;

import io.egen.prashanth.entity.Reading;
import io.egen.prashanth.entity.Vehicle;
import io.egen.prashanth.exception.NotfoundException;
import io.egen.prashanth.repository.AlertRepository;
import io.egen.prashanth.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ppeddabbu on 5/31/2017.
 */
@Service
public class ReadingServiceImpl implements ReadingService{

    @Autowired
    ReadingRepository readingRepo;
    @Autowired
    AlertRepository alertRepo;

    @Override
    @Transactional
    public Reading create(Reading reading){

        Vehicle vehicle = readingRepo.findVehicle(reading.getVin());
        if(vehicle == null){
            throw new NotfoundException("No vehicle found with ID : '"+ vehicle.getVin() +"'");
        }

        //trigger async alerts
        System.out.println("START: "+ System.currentTimeMillis());
        alertRepo.checkAndCreateAlerts(reading,vehicle);
        System.out.println("END: "+ System.currentTimeMillis());

        return readingRepo.create(reading);
    }
}