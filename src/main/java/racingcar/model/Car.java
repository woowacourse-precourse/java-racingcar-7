package racingcar.model;

public class Car {

    private CarName name;
    private int advanceCount = 0;

    private Car(String name) {
        this.name = new CarName(name);
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void advance(int number) {
        if (number > 3) {
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
