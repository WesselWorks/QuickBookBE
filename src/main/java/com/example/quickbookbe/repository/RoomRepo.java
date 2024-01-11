package com.example.quickbookbe.repository;

import com.example.quickbookbe.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>
{

}
