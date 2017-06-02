package io.egen.prashanth.repository;

import io.egen.prashanth.entity.Reading;
import io.egen.prashanth.entity.Vehicle;

/**
 * Created by ppeddabbu on 6/1/2017.
 */
public interface AlertRepository {

    public void checkAndCreateAlerts(Reading reading, Vehicle vehicle);
}
