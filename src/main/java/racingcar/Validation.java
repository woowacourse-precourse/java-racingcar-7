package racingcar;

public class Validation {

    void validateCarName(String carName) {
        if (carName.length() > 5);
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + carName);
    }
}
