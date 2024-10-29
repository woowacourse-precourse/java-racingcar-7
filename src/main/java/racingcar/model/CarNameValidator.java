package racingcar.model;

public class CarNameValidator {
    public void validate(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
