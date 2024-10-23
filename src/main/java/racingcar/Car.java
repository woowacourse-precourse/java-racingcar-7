package racingcar;

public class Car {

    private String name;
    private int forwardLevel;

    public Car() {
        this.forwardLevel = 0;
    }

    public void nameCar(String name) {
        this.name = name;
    }

    public String getCarName() {
        return this.name;
    }
}
