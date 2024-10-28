package racingcar;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validateNameLongerThanFive(carName);
        this.carName = carName;
    }

    public boolean isName(String givenName) {
        return this.carName.equals(givenName);
    }

    private void validateNameLongerThanFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + "이름이 5자리가 넘습니다");
        }
    }

    public String getCarName() {
        return this.carName;
    }
}
