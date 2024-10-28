package racingcar;

public class Validator {
    public void validateCarName(String carName) {
        if (carName.length() > 5 | carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
