package racingcar;

public class TestCar extends Car {
    private int fixedRandomValue;
    private int testDistance;
    public TestCar(String name, int fixedRandomValue) {
        super(name);
        this.fixedRandomValue = fixedRandomValue;
    }
    public TestCar(int testDistance, String name) {
        super(name);
        this.testDistance = testDistance;

        for (int i = 0; i < testDistance; i++) {
            addDistance();
        }
    }
    @Override
    public int random() {
        return fixedRandomValue;
    }
}
