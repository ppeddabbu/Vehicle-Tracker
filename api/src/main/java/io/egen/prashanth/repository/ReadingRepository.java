package io.egen.prashanth.repository;

import io.egen.prashanth.entity.Reading;
import io.egen.prashanth.entity.Vehicle;

/**
 * Created by ppeddabbu on 5/31/2017.
 */
public interface ReadingRepository {

    public Reading create(Reading reading);

    public Vehicle findVehicle(String vehicleID);
}
