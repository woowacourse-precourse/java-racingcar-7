package racingcar.model;

public class CarName {
    private String carName;

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        int nameLength = carName.length();
        if (!(0 < nameLength && nameLength <= 5)) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String getCarName() {
        return this.carName;
    }
}