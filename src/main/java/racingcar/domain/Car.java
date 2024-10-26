package racingcar.domain;

public class Car {
    private int position;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        position++;
    }

    public String getCarName() {
        return carName;
    }
}
