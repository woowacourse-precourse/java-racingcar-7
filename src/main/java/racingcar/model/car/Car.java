package racingcar.model.car;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void updatePosition(int fuel) {
        if (fuel >= 4) {
            this.position++;
        }
    }
}
