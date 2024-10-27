package racingcar.model;

public class Car {
    private final RandomIntGenerator randomIntGenerator;
    private final String carName;
    private int position;

    public Car(String carName, RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    // TODO: 이동 가능 여부에 따라 이동한다.

    // TODO: 이동 가능 여부를 판단한다.
}
