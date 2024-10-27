package racingcar.domain;

public class Car {

    private String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void move() {
        this.count++;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String s = "";
        s += getName() + " : " + "-".repeat(count);
        return s;
    }
}
