package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String CarName) {
        this.name = CarName;
    }

    public String getName() {
        return name;
    }

    void move(){
        position++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
