package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<>();

    public void addRoom(double length, double width, double height) {
        // Creates a room object and adds it to its list field.
        Room room = new Room(length, width, height);
        roomList.add(room);

    }

    public String toString() {
        if(roomList.isEmpty())
            return "There's no room";

        String result = "";
        for(Room room : roomList){
            result += room.toString() +"\n";
        }

        //return the list of room;
        return result;

    }
}
