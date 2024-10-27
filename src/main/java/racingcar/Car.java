package racingcar;

public class Car {
    private final String CarName;

    // 자동차 이름 5자 이하만 입력
    public Car(String CarName) {
        if (CarName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.CarName = CarName;
    }

    public String getCarName() {
        return CarName;
    }
}
