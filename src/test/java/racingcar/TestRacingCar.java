package racingcar;

public class TestRacingCar extends RacingCar {
    private int testPosition;

    public TestRacingCar(String name, int position) {
        super(name);
        this.testPosition = position;
    }

    @Override
    public int getPosition() {
        return testPosition;
    }
}