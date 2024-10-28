package racingcar;

public class Car {
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if(RandomNumberGenerator.pickRandomNumber() >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
