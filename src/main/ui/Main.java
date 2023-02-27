package ui;

import java.io.FileNotFoundException;

// Main class that creates a new MonstermonApp Object to run the application
public class Main {
    public static void main(String[] args) {
        try {
            new MonstermonApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        } catch (Exception e) {
            System.out.println("Something went wrong. Please run the application again.");
        }
    }
}
