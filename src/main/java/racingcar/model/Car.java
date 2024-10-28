package racingcar.model;

public class Car {

    private static final int MAX_NON_ADVANCE_NUMBER = 3;
    private final CarName name;
    private int advanceCount = 0;

    private Car(String name) {
        this.name = new CarName(name);
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void advance(int number) {
        if (number > MAX_NON_ADVANCE_NUMBER) {
            advanceCount++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getAdvanceCount() {
        return advanceCount;
    }
}
