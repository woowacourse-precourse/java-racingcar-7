package racingcar.model;

public class Location {

    private int location;

    public Location() {
        this.location = 0;
    }
    // 앞으로 움직이라는 메세지가 오면 location을 앞으로 이동
    public void moveForward() {
            location++;
    }

    public int getLocation() {
        return location;
    }
}
