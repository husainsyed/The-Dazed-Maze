# The Dazed Maze

A text-based adventure game that uses the concepts of Object-Oriented programming and utilizes Data Structures to function. 

## Instructions

The game is based on a maze. You start at room 'A' and you have to navigate through other rooms to get to the correct room. Each room has at most 4 neighbors. The neighboring rooms are listed to your North, South, East, and West positions respectively. If there is no neighboring room listed, it means you don't have a neighbor at that location. The rooms are labeled by English letters.

## How the game is structured

The game uses the techniques of Object-oriented programming and Data Structures to function. ```Main.java``` mainly handles the client interface, i.e., instructions and basic logic of the game. It also creates a ```Node``` object and populates the internal array of```Node.java``` with a character value of each room. Each entry of the internal array in ```Node.java``` represents a room. Furthermore, ```Node.java``` makes a call to a method in ```Match.java``` which populates a HashMap. In the HashMap, each ```key``` is a room and the corresponding ```value``` is a character array of length 4, indicating its neighbors.

## Aerial map of the maze
![alt te t](/aerial_map.JPG)
