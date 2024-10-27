package racingcar.model;

public class Car {
    String name;
    int distance;

    private Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move(Car car) {
        int randomNumber = RandomNumberGenerator.getRandomNumber();
        if (randomNumber >= 4) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


}
