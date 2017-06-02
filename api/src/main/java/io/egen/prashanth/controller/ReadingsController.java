package io.egen.prashanth.controller;

import io.egen.prashanth.entity.Reading;
import io.egen.prashanth.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ppeddabbu on 5/31/2017.
 */

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value ="readings")
public class ReadingsController {

    @Autowired
    ReadingService readService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading create(@RequestBody Reading reading){
        return readService.create(reading);
    }

}
