package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void forward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
