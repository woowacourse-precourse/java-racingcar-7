package racingcar.model;

public class Car {
    private String name;
    private StringBuilder position;

    private static final int MOVE_NUMBER = 4;


    public Car(String name) {
        this.name = name;
        this.position = new StringBuilder();
    }

    public String getPosition() {
        return position.toString();
    }

    public String getName() {
        return name;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_NUMBER) {
            position.append("-");
        }
    }

}
