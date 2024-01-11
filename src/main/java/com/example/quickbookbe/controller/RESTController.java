package com.example.quickbookbe.controller;

import com.example.quickbookbe.model.Hotel;
import com.example.quickbookbe.service.ServiceHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RESTController
{
    @Autowired
    private ServiceHotel serviceHotel;

    @GetMapping("/allhotels")
    public List<Hotel> getAllHotels()
    {
        return serviceHotel.findAllHotels();
    }

    @PostMapping("/newhotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return serviceHotel.saveHotel(hotel);
    }

    /*En forsimplet udgave af createHotel() uden ResponseEntity.

    @PostMapping("/newhotel")
    public Hotel createHotel(@RequestBody Hotel hotel)
    {
        return serviceHotel.saveHotel(hotel);
    }*/

}
