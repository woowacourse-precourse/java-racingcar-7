package racingcar.model;

public class Car {
    public String name;
    public Integer totalMovement = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getTotalMovement() {
        return totalMovement;
    }
}
