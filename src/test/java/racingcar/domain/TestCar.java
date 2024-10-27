package racingcar.domain;

public class TestCar extends Car {
    private final boolean movable;
    public TestCar(String name, boolean movable) {
        super(name);
        this.movable = movable; // 움직일지 말지를 임의로 결정
    }

    @Override
    protected boolean isMovable() {
        return movable;
    }
}