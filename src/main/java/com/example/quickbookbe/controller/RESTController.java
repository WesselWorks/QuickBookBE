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

    @PutMapping("/updatehotel/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody Hotel hotelDetails) {
        // Find the hotel by id and update it with hotelDetails
        Hotel updatedHotel = serviceHotel.updateHotel(id, hotelDetails);

        if (updatedHotel == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedHotel);
        }
    }


    /*En forsimplet udgave af createHotel() uden ResponseEntity.

    @PostMapping("/newhotel")
    public Hotel createHotel(@RequestBody Hotel hotel)
    {
        return serviceHotel.saveHotel(hotel);
    }*/

}
