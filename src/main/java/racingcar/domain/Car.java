package racingcar.domain;


public class Car {
    String name;
    int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position += randomValue;
        }
    }
}
