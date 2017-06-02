package io.egen.prashanth.repository;

import io.egen.prashanth.entity.Vehicle;

import java.util.List;

/**
 * Created by ppeddabbu on 5/30/2017.
 */
public interface VehicleRepository {

    public void upsert(List<Vehicle> vehicles);
}
