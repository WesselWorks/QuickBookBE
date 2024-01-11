package com.example.quickbookbe.service;

import com.example.quickbookbe.model.Hotel;
import com.example.quickbookbe.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServiceHotelImpl implements ServiceHotel
{
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public List<Hotel> findAllHotels()
    {
        return hotelRepo.findAll();
    }

    /* Denne metode returnere en ResponseEntity, som kan give
    en HTTP status kode tilbage til klienten afhængig af om
    det gik godt eller skidt */
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








    /* En forsimplet udgave af saveHotel() uden ResponseEntity.

    @Override
    public Hotel saveHotel(Hotel hotel)
    {
        return hotelRepo.save(hotel);
    }*/

}
