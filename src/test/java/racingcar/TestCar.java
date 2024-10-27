package racingcar;

public class TestCar extends Car {
    private int fixedRandomValue;

    public TestCar(String name, int fixedRandomValue) {
        super(name);
        this.fixedRandomValue = fixedRandomValue;
    }

    @Override
    public int random() {
        return fixedRandomValue;
    }
}
