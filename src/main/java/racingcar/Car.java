package racingcar;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }
}
