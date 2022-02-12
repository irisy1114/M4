package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();
    private static String fileName = "rooms.dat";

    public static void main(String[] args) {
        while(true) {
            printMenu();
            System.out.print("Enter selection: ");
            Integer option = Integer.parseInt(keyboard.nextLine());
            if(option == 5)
                break;
            switch (option) {
                case 1: createRoom();
                    System.out.println("Room successfully created.");
                break;
                case 2:
                    System.out.println(paintCalculator.toString());
                break;
                case 3: readFile();
                break;
                case 4: writeFile();
                break;
            }
        }
        System.out.println("Good bye");

    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Add room");
        System.out.println("2. View rooms");
        System.out.println("3. Read rooms from file");
        System.out.println("4. Write rooms to file");
        System.out.println("5. Exit program");
        System.out.println();
    }

    private static double promptForDimension(String dimensionName) {
        // Prints a prompt for the user to enter the given dimension and returns their response
        System.out.print("Enter the room's " + dimensionName + ": ");
        return Double.parseDouble(keyboard.nextLine());
    }

    private static void createRoom() {
        // Prompts the user to enter length, width, and height.
        // Tells the paint calculator to add a room using given dimensions.
        double length = promptForDimension("length");
        double width = promptForDimension("width");
        double height = promptForDimension("height");

        paintCalculator.addRoom(length, width, height);
    }

    private static void readFile() {
        // Reads a paint calculator object from a file and sets it to the field.
        // Using exception handling, prints an error if the file cannot be read.
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            paintCalculator = (PaintCalculator)ois.readObject();
            System.out.println("File read successfully");
            ois.close();
        }
        catch (ClassCastException e){
            System.out.println("No rooms yet");
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Oh no, file can't be read!");
            e.printStackTrace();
        }
    }

    private static void writeFile() {
        // 	Writes the paint calculator field to a file.
        // 	Using exception handling, prints an error if the file cannot be written.
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(paintCalculator);
            System.out.println("File written successfully");
            oos.close();
        } catch (IOException e) {
            System.out.println("Sorry, file can't be written.");
            e.printStackTrace();
        }
    }
}
