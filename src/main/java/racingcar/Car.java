package racingcar;

public class Car {
    private final CarName carName;
    private MoveCount moveCount;

    public Car(String name) {
        this.carName = new CarName(name);
        this.moveCount = new MoveCount(0);
    }
}
