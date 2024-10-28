package racingcar.Model;

public class Car {
    private final String CarName;
    private int Position = 0;

    public Car(String carName) {
        CarName = carName;
    }

    public void move(int RandomNumber) {
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
