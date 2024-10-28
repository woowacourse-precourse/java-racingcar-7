package racingcar;

public class Car {

    private String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public void increaseCount() {
        this.count++;
    }
}
