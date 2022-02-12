package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private List<Wall> wallList = new ArrayList<>();

    public Room(double width, double length, double height) {
        Wall frontWall = new Wall(width, height);
        Wall backWall = new Wall(width, height);
        Wall leftWall = new Wall(length, height);
        Wall rightWall = new Wall(length, height);

        wallList.add(frontWall);
        wallList.add(backWall);
        wallList.add(leftWall);
        wallList.add(rightWall);

    }

    public double getArea() {
        // returns the calculated area of the room
        double roomArea = 0;
        for(Wall wall: wallList) {
            roomArea += wall.getArea();
        }
        return roomArea;

    }

    public String toString() {
        return "Room with area: " + getArea();

    }
}
