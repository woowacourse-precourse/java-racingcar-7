package racingcar;

public class Car implements Comparable<Car> {
    private String name;
    private int pos;

    public Car(String name) {
        this.name = name;
        this.pos = 0;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.pos, other.pos);
    }

    public void goAhead() {
        pos ++;
    }

    public String getName() {
        return name;
    }
    public int getPos() {
        return pos;
    }
}
