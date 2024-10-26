package racingcar.model;

public class Car {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean moveOrStop(int randomNum) {
        return (randomNum >= 4);
    }

    public String getName() {
        return name;
    }
}
