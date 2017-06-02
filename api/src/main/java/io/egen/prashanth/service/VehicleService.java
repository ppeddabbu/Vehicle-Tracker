package io.egen.prashanth.service;

import io.egen.prashanth.entity.Vehicle;

import java.util.List;

/**
 * Created by ppeddabbu on 5/30/2017.
 */
public interface VehicleService {

    public void upsert(List<Vehicle> vehicles);

}
