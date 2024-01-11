package com.example.quickbookbe.configuration;

import com.example.quickbookbe.model.Hotel;
import com.example.quickbookbe.model.Room;
import com.example.quickbookbe.repository.HotelRepo;
import com.example.quickbookbe.repository.RoomRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


@Component
public class InitData implements CommandLineRunner
{

    private final HotelRepo hotelRepo;
    private final RoomRepo roomRepo;
    private final Random random = new Random();

    private static final String[] COUNTRIES = {"USA", "Canada", "Denmark", "France", "Spain"};
    private static final String[] CITIES = {"New York", "Toronto", "Copenhagen", "Paris", "Madrid"};
    private static final String[] STREETS = {"Main St", "Maple Ave", "Kgs Nytorv", "Champs-Élysées", "Gran Via"};
    private static final String[] ZIP_CODES = {"10001", "M5H 2N2", "1000", "75008", "28013"};
    private static final String[] HOTEL_NAMES = {"Azure Sky Hotel", "Maple Tree Inn", "Golden Sands Resort", "Cozy Corner Hotel", "Starlight Suites", "Blue Horizon Hotel", "Serenity Inn", "Ocean View Hotel", "Mountain Peak Lodge", "Urban Retreat Hotel", "Sunset Hotel & Spa", "Grand Heritage Hotel", "City Center Boutique Hotel", "Royal Palm Resort", "Harborview Hotel", "Lakeside Hotel & Spa", "Meadowlands Hotel", "Crystal Tower Hotel", "Riverside Inn", "Skyline Luxury Suites", "Green Valley Lodge", "Eagle's Nest Resort", "Silver City Hotel", "Orchard Garden Hotel", "Twilight Bay Resort"};

    public InitData(HotelRepo hotelRepo, RoomRepo roomRepo)
    {
        this.hotelRepo = hotelRepo;
        this.roomRepo = roomRepo;
    }

    @Override
    public void run(String... args) throws Exception
    {

        for (int i = 0; i < 25; i++)
        {
            int countryIndex = random.nextInt(COUNTRIES.length);
            Hotel hotel = new Hotel();
            hotel.setName(HOTEL_NAMES[i]);
            hotel.setCountry(COUNTRIES[countryIndex]);
            hotel.setCity(CITIES[countryIndex]);
            hotel.setZip(ZIP_CODES[countryIndex]);
            hotel.setStreet(STREETS[countryIndex] + " No. " + (1 + random.nextInt(100))); // Randomizing street number
            hotel.setCreated(LocalDateTime.now());
            hotel.setUpdated(LocalDateTime.now());
            hotel = hotelRepo.save(hotel);

            int roomsCount = 10 + random.nextInt(31); // 10 to 40 rooms
            Set<Room> rooms = new HashSet<>();
            for (int j = 1; j <= roomsCount; j++)
            {
                Room room = new Room();
                room.setRoomNumber("Room " + j);
                room.setNumberOfBeds(1 + random.nextInt(4)); // 1 to 4 beds
                room.setPrice(50 + random.nextInt(151)); // Price between 50 to 200, for example
                room.setCreated(LocalDateTime.now());
                room.setUpdated(LocalDateTime.now());
                room.setHotel(hotel);
                rooms.add(room);
            }
            roomRepo.saveAll(rooms); // Save all rooms at once
        }
    }

}

    /* Create 250 unique hotels with 10 to 40 rooms each.

    private final HotelRepo hotelRepo;
    private final RoomRepo roomRepo;
    private final Random random = new Random();

    private static final String[] COUNTRIES = {"USA", "Canada", "Denmark", "France", "Spain"};
    private static final String[] CITIES = {"New York", "Toronto", "Copenhagen", "Paris", "Madrid"};
    private static final String[] STREETS = {"Main St", "Maple Ave", "Kgs Nytorv", "Champs-Élysées", "Gran Via"};
    private static final String[] ZIP_CODES = {"10001", "M5H 2N2", "1000", "75008", "28013"};
    private static final String[] UNIQUE_HOTEL_NAMES = generateUniqueHotelNames(250); // Generate 250 "unique" hotel names

    public InitData(HotelRepo hotelRepo, RoomRepo roomRepo)
    {
        this.hotelRepo = hotelRepo;
        this.roomRepo = roomRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 250; i++) {
            int countryIndex = random.nextInt(COUNTRIES.length);
            Hotel hotel = new Hotel();
            hotel.setName(UNIQUE_HOTEL_NAMES[i]);
            hotel.setCountry(COUNTRIES[countryIndex]);
            hotel.setCity(CITIES[countryIndex]);
            hotel.setZip(ZIP_CODES[countryIndex]);
            hotel.setStreet(STREETS[countryIndex] + " No. " + (1 + random.nextInt(100))); // Randomizing street number
            hotel.setCreated(LocalDateTime.now());
            hotel.setUpdated(LocalDateTime.now());
            hotel = hotelRepo.save(hotel);

            int roomsCount = 10 + random.nextInt(31); // 10 to 40 rooms
            Set<Room> rooms = new HashSet<>();
            for (int j = 1; j <= roomsCount; j++)
            {
                Room room = new Room();
                room.setRoomNumber("Room " + j);
                room.setNumberOfBeds(1 + random.nextInt(4)); // 1 to 4 beds
                room.setPrice(50 + random.nextInt(151)); // Price between 50 to 200, for example
                room.setCreated(LocalDateTime.now());
                room.setUpdated(LocalDateTime.now());
                room.setHotel(hotel);
                rooms.add(room);
            }
            roomRepo.saveAll(rooms); // Save all rooms at once
        }
    }

    private static String[] generateUniqueHotelNames(int count)
    {
        String[] uniqueNames = new String[count];
        for (int i = 0; i < count; i++)
        {
            uniqueNames[i] = "Hotel " + (i + 1);
        }
        return uniqueNames;
    }*/


