public class Node {
    //Instance variables
    private char[] actualRooms;
    private static final int CONSTANT_SIZE = 12;
    private int pos;
    Match createMatch = new Match();

    //Constructor
    public Node() {
        actualRooms = new char[CONSTANT_SIZE];
        pos = 0;
    }

    //Returning the size
    public int size() {
        return actualRooms.length;
    }

    //Adds a 'room' to the array
    public void add(char data) {
        actualRooms[pos] = data;
        pos++;
    }


    //Calls the makeNeighbor() method of Match class via createMatch object
    //each entry of actualRooms array is a room ranging from 'A' to 'L'
    //The first parameter of makeNeighbor is the key of a map.

    //The second parameter is the value of the map: Value is an array of its neighboring rooms
    //The array has a fixed size of 4. 1st entry of array is North, 2nd is South, 3rd is East, 4th is West
    //X denotes there is no neighbor at that side
    public void createNeighbors() {
        createMatch.makeNeighbor(actualRooms[0], new char[] { 'X', 'D', 'B', 'X' });
        createMatch.makeNeighbor(actualRooms[1], new char[] { 'X', 'E', 'C', 'A' });
        createMatch.makeNeighbor(actualRooms[2], new char[] { 'X', 'F', 'X', 'B' });
        createMatch.makeNeighbor(actualRooms[3], new char[] { 'A', 'G', 'E', 'X' });
        createMatch.makeNeighbor(actualRooms[4], new char[] { 'B', 'X', 'F', 'D' });
        createMatch.makeNeighbor(actualRooms[5], new char[] { 'C', 'I', 'X', 'E' });
        createMatch.makeNeighbor(actualRooms[6], new char[] { 'D', 'J', 'x', 'X' });
        createMatch.makeNeighbor(actualRooms[7], new char[] { 'X', 'X', 'I', 'X' });
        createMatch.makeNeighbor(actualRooms[8], new char[] { 'F', 'L', 'X', 'H' });
        createMatch.makeNeighbor(actualRooms[9], new char[] { 'G', 'X', 'K', 'X' });
        createMatch.makeNeighbor(actualRooms[10], new char[] { 'X', 'X', 'X', 'J' });
        createMatch.makeNeighbor(actualRooms[11], new char[] { 'I', 'X', 'X', 'X' });
    }

    //Returns the array containing neighbors of a room
    public char[] showMatches(char c) {
        for (char found : createMatch.validNeighbors.keySet()) {
            if (c == found) {
                return createMatch.validNeighbors.get(found);

            }
        }

        return new char[] { '0' };
    }


    //Overriding the default toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(actualRooms[0]);
        for (int i = 1; i < actualRooms.length; i++) {
            sb.append(", ");
            sb.append(actualRooms[i]);
        }
        return sb.toString();
    }

}