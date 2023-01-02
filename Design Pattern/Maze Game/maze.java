public class MazeGame{

    Maze CreateMaze();

    public static Maze makeMaze() {
        return new Maze();
    }

    public static Room makeRoom(int n) {
        return new Room(n);
    }

    public static Wall makeWall() {
        return new Room();
    }

    public static Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }

    Maze MazeGame::CreateMaze () {

        Maze aMaze = MakeMaze();
        Room rl = MakeRoom(1);
        Room r2 = MakeRoom(2);
        Door theDoor = MakeDoor(rl, r2);
        aMaze.AddRoom(rl);
        aMaze.AddRoom(r2);
        rl.SetSide(North, MakeWall());
        rl.SetSide(East, theDoor);
        rl.SetSide(South, MakeWall());
        rl.SetSide(West, MakeWall());
        r2.SetSide(North, MakeWall());
        r2.SetSide(East, MakeWall());
        r2.SetSide(South, MakeWall());
        r2.SetSide(West, theDoor);
        return aMaze;
    }
    
}

public class BombedMazeGame : public MazeGame {
    
    BombedMazeGame();
    public static Wall MakeWall(){
        return new BombedWall;
    }
    public static  Room MakeRoom(int n){
        return new RoomWithABomb(n);
    }
}

public class EnchantedMazeGame : public MazeGame {
    
    EnchantedMazeGame();
    public static Room MakeRoom(int n){
        return new EnchantedRoom(n, CastSpell());
    }
    public static Door MakeDoor(Room* rl, Room* r2){
        return new DoorNeedingSpell(rl, r2);
    }
    protected static Spell CastSpell();
}