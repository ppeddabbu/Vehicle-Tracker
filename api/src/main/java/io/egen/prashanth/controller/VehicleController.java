package io.egen.prashanth.controller;


import io.egen.prashanth.entity.Vehicle;
import io.egen.prashanth.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
//origins = "http://mocker.egen.io/",

@CrossOrigin( origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicles")
public class VehicleController {

    @Autowired
    VehicleService vService;

    //TODO: return ?? value ??
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public void upsert(@RequestBody List<Vehicle> vehicles) {
      /*  for(Vehicle v : vehicles){
          System.out.println(v);
        }*/
        vService.upsert(vehicles);

    }

}

