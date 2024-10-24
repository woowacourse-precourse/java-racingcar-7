package racingcar;

public abstract class Car {
    protected String carName;
    protected int currentPosition;

    public Car(String name) {
        this.carName = name;
        this.currentPosition = 0;
    }

    public boolean isAheadOf(Car otherCar) {
        return this.currentPosition > otherCar.currentPosition; // 현재 자동차가 다른 자동차보다 앞서 있는지 확인
    }

    public boolean isAtSamePosition(Car otherCar) {
        return this.currentPosition == otherCar.currentPosition; // 현재 자동차와 다른 자동차의 위치가 같은지 확인
    }

    public CarDTO toDTO() {
        return new CarDTO(carName, currentPosition);
    }


}
