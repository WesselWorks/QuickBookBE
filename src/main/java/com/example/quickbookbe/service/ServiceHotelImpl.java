package com.example.quickbookbe.service;

import com.example.quickbookbe.model.Hotel;
import com.example.quickbookbe.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceHotelImpl implements ServiceHotel
{
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public ResponseEntity<List<Hotel>> findAllHotels()
    {
        List<Hotel> hotels = hotelRepo.findAll();
        return ResponseEntity.ok(hotels);
    }

    @Override
    public ResponseEntity<Hotel> saveHotel(Hotel hotel)
    {
        try
        {
            Hotel savedHotel = hotelRepo.save(hotel);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Hotel> updateHotel(int id, Hotel hotelDetails)
    {
        Hotel existingHotel = hotelRepo.findById(id).orElse(null);
        if (existingHotel == null)
        {
            return ResponseEntity.notFound().build();
        }
        existingHotel.setName(hotelDetails.getName());
        existingHotel.setStreet(hotelDetails.getStreet());
        existingHotel.setCity(hotelDetails.getCity());
        existingHotel.setZip(hotelDetails.getZip());
        existingHotel.setCountry(hotelDetails.getCountry());
        existingHotel.setUpdated(LocalDateTime.now());

        Hotel updatedHotel = hotelRepo.save(existingHotel);
        return ResponseEntity.ok(updatedHotel);
    }

    @Override
    public ResponseEntity<Void> deleteHotel(int id)
    {
        if (hotelRepo.existsById(id))
        {
            hotelRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
