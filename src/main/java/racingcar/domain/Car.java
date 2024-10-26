package racingcar.domain;

public class Car {
    private final static int MOVE_STANDARD = 4;
    private final String carName;
    private int position;

    protected Car(String carName) {
        this.carName = carName;
    }

    private void move() {
        position++;
    }

    public void judgeMove(int randomNumber) {
        if (randomNumber >= MOVE_STANDARD) {
            move();
        }
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
