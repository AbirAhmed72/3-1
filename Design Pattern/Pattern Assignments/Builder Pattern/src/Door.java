public class Door extends MapSite {
    Door(Room room1, Room room2) {
        _room1 = room1;
        _room2 = room2;
        _isOpen = false;
    }

    public void enter() {
        System.out.println("Enter");
    }

    Room otherSideFrom(Room room) {
        if (room == _room1) {
            return _room2;
        } else if (room == _room2) {
            return _room1;
        }
        return null;
    }

    private Room _room1;
    private Room _room2;
    private boolean _isOpen;
}
