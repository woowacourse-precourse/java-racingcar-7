package racingcar.car;

public class Car {
    private final String name;
    private int totalMove;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalMove() {
        return totalMove;
    }

    public void setTotalMove() {
        totalMove = totalMove + 1;
    }
}
