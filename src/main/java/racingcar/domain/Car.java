package racingcar.domain;

public class Car {
    private CarName name;
    private int position;

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public void moveForward(int distance) {
        position += distance;
    }

    public String getCarName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
