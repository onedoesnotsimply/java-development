import com.pluralsight.*;

import java.util.ArrayList;

public class HotelExerciseDriver {
    static ArrayList<Room> rooms = new ArrayList<Room>();
    public static void main(String[] args) {
        // Add the rooms to the arraylist
        populateRooms();



        // Create a reservation for a suite
        Reservation reservation1 = new Reservation("King", 3,false);
        // Create reservations for double rooms, we only need to check for
        Reservation reservation2 = new Reservation("", 2, true);
        Reservation reservation3 = new Reservation("", 4, false);
        Reservation reservation4 = new Reservation("", 2,false);

        // Check the person into the suite
        Room bookedRoom = rooms.get(0);
        bookedRoom.checkIn();

        // Check people into their rooms
        Room bookedRoom2 = rooms.get(2);
        bookedRoom2.checkIn();
        Room bookedRoom3 = rooms.get(3);
        bookedRoom3.checkIn();
        Room bookedRoom4 = rooms.get(4);
        bookedRoom4.checkIn();


        // Create a hotel with the rooms from the room list
        Hotel hotel1 = new Hotel("Flower", 4, 2, 1, 3);
        
    }
    
    public static void populateRooms() {
        Room room1 = new Room(4,false,false);
        Room room2 = new Room(4,false,false);
        Room room3 = new Room(2,false,false);
        Room room4 = new Room(2,false,false);
        Room room5 = new Room(2,false,false);
        Room room6 = new Room(2,false,false);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
    }
}
