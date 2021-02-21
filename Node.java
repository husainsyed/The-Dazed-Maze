public class Node {
    // Instance variables
    private char[] actualRooms;
    private static final int CONSTANT_SIZE = 12;
    private int pos;
    Match createMatch;

    // Constructor
    public Node() {
        actualRooms = new char[CONSTANT_SIZE];
        pos = 0;
        createMatch = new Match();
    }

    // Returning the size
    public int size() {
        return actualRooms.length;
    }

    // Adds a 'room' to the array
    public void add(char data) {
        actualRooms[pos] = data;
        pos++;
    }

    // Calls the makeNeighbor() method of Match class via createMatch object
    // each entry of actualRooms array is a room ranging from 'A' to 'L'
    // The first parameter of makeNeighbor is the key of a map.

    // The second parameter is the value of the map: Value is an array of its
    // neighboring rooms
    // The array has a fixed size of 4. 1st entry of array is North, 2nd is South,
    // 3rd is West, 4th is East
    // Blank space denotes there is no neighbor at that side
    public void createNeighbors() {
        createMatch.makeNeighbor(actualRooms[0], new char[] { ' ', 'D', ' ', 'B' });
        createMatch.makeNeighbor(actualRooms[1], new char[] { ' ', 'E', 'A', 'C' });
        createMatch.makeNeighbor(actualRooms[2], new char[] { ' ', 'F', 'B', ' ' });
        createMatch.makeNeighbor(actualRooms[3], new char[] { 'A', 'G', ' ', 'E' });
        createMatch.makeNeighbor(actualRooms[4], new char[] { 'B', ' ', 'D', 'F' });
        createMatch.makeNeighbor(actualRooms[5], new char[] { 'C', 'I', 'E', ' ' });
        createMatch.makeNeighbor(actualRooms[6], new char[] { 'D', 'J', ' ', ' ' });
        createMatch.makeNeighbor(actualRooms[7], new char[] { ' ', ' ', ' ', 'I' });
        createMatch.makeNeighbor(actualRooms[8], new char[] { 'F', 'L', 'H', ' ' });
        createMatch.makeNeighbor(actualRooms[9], new char[] { 'G', ' ', ' ', 'K' });
        createMatch.makeNeighbor(actualRooms[10], new char[] { ' ', ' ', ' ', 'J' });
        createMatch.makeNeighbor(actualRooms[11], new char[] { 'I', ' ', ' ', ' ' });
    }

    // Returns the string containing neighbors of a room
    public String showMatches(char c) {
        for (char found : createMatch.validNeighbors.keySet()) {

            // Formatting the string so the user can have a better view of their position
            if (c == found) {
                StringBuilder sb = new StringBuilder();
                char[] familyElements = createMatch.validNeighbors.get(found);
                sb.append("        " + familyElements[0] + "\n" + getDirection('v'));
                sb.append(familyElements[2] + getDirection('h') + c + getDirection('h') + familyElements[3] + "\n");
                sb.append(getDirection('v') + "        " + familyElements[1]);
                return sb.toString();

            }
        }

        return null;
    }

    // helper method for the above string formatting method
    private static String getDirection(char dir) {
        StringBuilder sb = new StringBuilder();

        if (dir == 'v') {
            for (int i = 0; i < 2; i++) {
                sb.append("        |\n");
            }
        }

        else {
            sb.append(" ");
            for (int i = 0; i < 5; i++) {
                sb.append("-");
            }
            sb.append(" ");

        }

        return sb.toString();

    }
}