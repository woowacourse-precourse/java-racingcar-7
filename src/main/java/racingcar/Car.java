package racingcar;

public class Car {
    private final String name;
    private StringBuilder position = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position.append("-");
        }
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position.toString();
    }

    public int getPositionLength() {
        return position.length();
    }
}
