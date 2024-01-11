package com.example.quickbookbe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate reservedFromDate;
    private LocalDate reservedToDate;
    private int price;
    private LocalDateTime created;
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference("room-reservation")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    @JsonBackReference("guest-reservation")
    private Guest guest;

    // Getter og Settere
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getReservedFromDate() {
        return reservedFromDate;
    }

    public void setReservedFromDate(LocalDate reservedFromDate) {
        this.reservedFromDate = reservedFromDate;
    }

    public LocalDate getReservedToDate() {
        return reservedToDate;
    }

    public void setReservedToDate(LocalDate reservedToDate) {
        this.reservedToDate = reservedToDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
