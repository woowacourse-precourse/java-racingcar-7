package racingcar.Model;

public class Car {
    private final String CarName;
    private int Position = 0;
    private int RandomNumber;

    public Car(String carName) {
        CarName = carName;
    }

    public void move() {
        if (RandomNumber >= 4) {
            Position++;
        }
    }

    public String getName() {
        return CarName;
    }

    public int getPosition() {
        return Position;
    }


}
