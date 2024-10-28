package racingcar.domain;

public class Car {
    private final String carName;
    private int mileage = 0;

    private Car(String carName) {
        this.carName = carName;
    }

    public static Car registerCarNameFrom(String carName) {
        return new Car(carName);
    }

    public String getCarName() {
        return carName;
    }

    public int getMileage() {
        return mileage;
    }

    // 실질적으로 자동차를 한 칸 이동시키는 메소드
    public void moveCar() {
        this.mileage += 1;
    }
}
