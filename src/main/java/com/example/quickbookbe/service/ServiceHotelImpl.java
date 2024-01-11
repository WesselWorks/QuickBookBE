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
    public List<Hotel> findAllHotels()
    {
        return hotelRepo.findAll();
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
    public Hotel updateHotel(int id, Hotel hotelDetails)
    {
        Hotel hotel = hotelRepo.findById(id).orElse(null);

        if (hotel != null)
        {
            // Opdater hotel properties
            hotel.setName(hotelDetails.getName());
            hotel.setStreet(hotelDetails.getStreet());
            hotel.setCity(hotelDetails.getCity());
            hotel.setZip(hotelDetails.getZip());
            hotel.setCountry(hotelDetails.getCountry());
            hotel.setUpdated(LocalDateTime.now());
            return hotelRepo.save(hotel);
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean deleteHotel(int id)
    {
        if (hotelRepo.existsById(id))
        {
            hotelRepo.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }

}
