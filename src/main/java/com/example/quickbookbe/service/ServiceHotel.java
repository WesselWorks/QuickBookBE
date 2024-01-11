package com.example.quickbookbe.service;

import com.example.quickbookbe.model.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceHotel
{
    ResponseEntity<List<Hotel>> findAllHotels();

    ResponseEntity<Hotel> saveHotel(Hotel hotel);

    ResponseEntity<Hotel> updateHotel(int id, Hotel hotelDetails);

    ResponseEntity<Void> deleteHotel(int id);
}
