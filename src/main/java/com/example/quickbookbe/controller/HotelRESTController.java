package com.example.quickbookbe.controller;

import com.example.quickbookbe.model.Hotel;
import com.example.quickbookbe.service.ServiceHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class HotelRESTController {
    @Autowired
    private ServiceHotel serviceHotel;

    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> allHotels()
    {
        return serviceHotel.findAllHotels();
    }

    @PostMapping("/hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return serviceHotel.saveHotel(hotel);
    }

    @PutMapping("/hotel/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody Hotel hotelDetails)
    {
        return serviceHotel.updateHotel(id, hotelDetails);
    }

    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable int id)
    {
        return serviceHotel.deleteHotel(id);
    }

}
