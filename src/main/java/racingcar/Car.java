package racingcar;

public class Car {

    private final String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public void increaseCount() {
        this.count++;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(count);
    }
}
