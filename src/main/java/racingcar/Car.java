package racingcar;

public class Car {
    private Integer location;
    private String name;

    public Car(String name) {
        location = 0;
        this.name = name;
    }

    public Car() {
        location = 0;
    }

    public void move() {
        // 이후 구현
    }

    public void randomMove() {
        // 이후 구현
    }

    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
