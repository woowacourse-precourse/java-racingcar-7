package racingcar.Model;

public class Car {

    private final String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position = "";
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void move() {
        this.position += "-";
    }

    public int getDistance() {
        return position.length();
    }
}
