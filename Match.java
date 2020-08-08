import java.util.HashMap;
import java.util.Map;

public class Match {
    Map<Character, char[]> validNeighbors;

    //Constructor
    public Match() {
        validNeighbors = new HashMap<>();
    }

    //Puts the key-value pair in the map
    public void makeNeighbor(char c, char[] neighborArray) {
        validNeighbors.put(c, neighborArray);

    }

}