package racingcar;

public class Car implements Comparable<Car> {
    private String name;
    private int randomNumber;
    private int currentPos;

    public Car(String name) {
        this.name = name;
        this.randomNumber = 0;
        this.currentPos = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void incCurrentPos() {
        this.currentPos++;
    }

    @Override
    public int compareTo(Car o) {
        return this.currentPos - o.getCurrentPos();
    }
}
