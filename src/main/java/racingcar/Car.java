package racingcar;

public class Car {
    private String CarName;

    public Car(String CarName) {
        if (CarName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.CarName = CarName;
    }
}
