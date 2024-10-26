package racingcar.Model;

public class Car {
    private final String carName;
    private int moveStatus;

    public Car(String CarName, int Movestatus) {
        this.carName = CarName;
        this.moveStatus = 0;
    }
    public String getName() {
        return this.carName;
    }
    public int getMovestatus() {
        return this.moveStatus;
    }
    public void move() {
        this.moveStatus += 1;
    }
}
