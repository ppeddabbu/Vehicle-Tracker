package io.egen.prashanth.service;

import io.egen.prashanth.entity.Vehicle;
import io.egen.prashanth.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ppeddabbu on 5/30/2017.
 */

@Service
public class VechicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vRepo;

    @Override
    @Transactional
    public void upsert(List<Vehicle> vehicles) {
        vRepo.upsert(vehicles);
    }
}
