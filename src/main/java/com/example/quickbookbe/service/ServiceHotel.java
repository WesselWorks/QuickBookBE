package com.example.quickbookbe.service;

import com.example.quickbookbe.model.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceHotel
{
    List<Hotel> findAllHotels();

    ResponseEntity<Hotel> saveHotel(Hotel hotel);

    Hotel updateHotel(int id, Hotel hotelDetails);

    boolean deleteHotel(int id);
}
