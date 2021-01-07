/*
The Dazed Maze
Original Author: Syed Husain 
email: syedhusain@utexas.edu
*/

import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {

        // Initializing all the rooms as Node objects: Starting from 'A' till 'L'
        Node initialRoomList = new Node();
        char startRoom = 'A';
        for (int i = startRoom; i <= 'L'; i++) {
            initialRoomList.add(startRoom);
            startRoom++;
        }

        // The createNeighbors() method will create neighbors using a map
        // Keys would be the actual rooms, the values would be its corresponding
        // neighbors
        initialRoomList.createNeighbors();

        // current is the start position. target is where the user will have to reach.
        char current = 'A';
        char target = 'H';

        // Initializing Scanner for user input
        Scanner console = new Scanner(System.in);

        // Instructions/Manual of the game
        System.out.println("***Welcome to The Dazed Maze.***\n");
        System.out.println("There are " + initialRoomList.size() + " rooms in this maze.");
        System.out.println("You are currently in room " + current + ". You will see at most 4 neighbors.");

        System.out.println("The rooms are labeled by English letters. You are only allowed to enter CAPITALIZED LETTER of the room you wish to go to.");
        System.out.println("The neighboring rooms are listed to your North, South, East, and West positions respectively.");
        System.out.println("If there is no neighboring room listed, it means you don't have a neighbor at that location.\n");
        System.out.println("***Enough of instructions! God Speed!*** \n \n");

        // Fencepost technique
        String output = initialRoomList.showMatches(current);
        System.out.println("You are at room: " + current + ". Your neighbors are: \n");
        System.out.println(output + "\n");

        System.out.print("Choose where you want to be headed: ");
        current = console.next().charAt(0);

        // This loop will keep taking input from the user until they reach the target
        // room
        while ((!containsLetter(output, current)) || (current != target)) {

            // Error handling: If the user puts an invalid response
            if (!containsLetter(output, current)) {
                while (!containsLetter(output, current)) {
                    System.out.println("\nInvalid entry. Enter a valid choice from one of the following: \n");
                    System.out.print(output);
                    current = console.next().charAt(0);
                }
            }

            else {

                System.out.println("\nYour neighbors are: \n");
                System.out.println(initialRoomList.showMatches(current));
                output = initialRoomList.showMatches(current);
                System.out.print("\nChoose where you want to be headed: ");
                current = console.next().charAt(0);

            }

        }

        console.close();
        // When the user reaches the end of the game
        System.out.println("Congratulations! You made it. Thank you for playing!");
        System.out.println("To view the aerial map of this game, visit https://github.com/husainsyed");

    }

    // Error-handling helper method:
    // Checks if the input by the user is valid, i.e., must be in within the range
    // of the valid rooms
    private static boolean containsLetter(String arr, char current) {
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == current) {
                return true;
            }
        }
        return false;
    }

}