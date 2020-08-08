/*
The Dazed Maze
Original Author: Syed Husain 
email: syedhusain@utexas.edu
Copyrights protected.
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
        System.out.println("***Welcome to The Dazed Maze.***");
        System.out.println("There are " + initialRoomList.size() + " rooms in this maze.");
        System.out.println("You are currently in room " + current + ". You will see at most 4 neighbors.");
        System.out.println("The 1st neighbor is at North of you, 2nd is South, 3rd is East, and 4th is West.");
        System.out.println("X denotes there is no neighbor at that position.");
        System.out.println("The rooms are labeled by Englist letters. You are only allowed to enter CAPITALIZED LETTER of the room you wish to go to. \n");
        System.out.println("***Enough of instructions! God Speed!*** \n \n");

        // Fencepost technique
        char[] output = initialRoomList.showMatches(current);
        System.out.print("You are at room: " + current + ". Your neighbors are: ");
        System.out.println(output);

        System.out.print("Choose where you want to be headed: ");
        current = console.next().charAt(0);

        // This loop will keep taking input from the user until they reach the target
        // room
        while ((!containsLetter(output, current)) || (current != target)) {

            // Error handling: If the user puts an invalid response
            if (!containsLetter(output, current)) {
                while (!containsLetter(output, current)) {
                    System.out.print("Invalid entry. Enter a valid choice from one of the following: ");
                    System.out.println(output);
                    current = console.next().charAt(0);
                }
            }

            else {

                System.out.print("Your neighbors are: ");
                System.out.println(initialRoomList.showMatches(current));
                output = initialRoomList.showMatches(current);
                System.out.print("Choose where you want to be headed: ");
                current = console.next().charAt(0);

            }

        }

        // When the user reaches the end of the game
        System.out.println("Congratulations! You made it. Thank you for playing!");
        System.out.println("To view the aerial map of this game, visit https://github.com/husainsyed");

    }

    // Error-handling helper method:
    // Checks if the input by the user is valid, i.e., must be in within the range
    // of the valid rooms
    private static boolean containsLetter(char[] arr, char current) {
        if (current == 'X') {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == current) {
                return true;
            }
        }
        return false;
    }

}