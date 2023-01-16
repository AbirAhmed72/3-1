public class Room extends MapSite {
    Room(int roomNo) {
        _roomNumber = roomNo;
    }

    MapSite getSide(Direction dir) {
        return _sides[dir.ordinal()];
    }

    void setSide(Direction dir, MapSite site) {
        _sides[dir.ordinal()] = site;
    }

    public void enter() {
        System.out.println("Enters");
    }

    private MapSite[] _sides = new MapSite[4];
    private int _roomNumber;
}

