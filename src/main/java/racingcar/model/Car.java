package racingcar.model;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveIfPossible(int randomNumber) {
        if (randomNumber >= 4) {
            this.position ++;
        }
    }
}
