package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void checkIn_should_make_room_occupied_and_dirty(){
        // Arrange
        // Create a new room object that isn't occupied or dirty
        Room room = new Room(1,false,false);
        // Act
        room.checkIn();

        // Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void checkOut_should_leave_room_unoccupied_and_dirty() {
        //Arrange
        // Create an occupied and dirty room object
        Room room = new Room(1,true,false);

        // Act
        room.checkOut();

        // Assert
        assertTrue(room.isDirty());
        assertFalse(room.isOccupied());
    }

    @Test
    public void cleanRoom_should_cleanRoom() {
        // Can be used whether the room is occupied or not
        // Arrange
        Room room = new Room(1,false,true);

        // Act
        room.cleanRoom();

        // Assert
        assertFalse(room.isDirty());
    }
}