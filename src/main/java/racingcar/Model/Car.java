package racingcar.Model;

public class Car {
    private final String carName;
    private int moveStatus;

    public String getName() {
        return this.carName;
    }
    public int getMovestatus() {
        return this.moveStatus;
    }
    public Car(String CarName) {
        this.carName = CarName;
        this.moveStatus = 0;
    }
    public void move() {
        this.moveStatus += 1;
    }
}
