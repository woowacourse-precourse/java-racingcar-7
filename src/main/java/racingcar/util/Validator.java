package racingcar.util;

public class Validator {
    public Boolean validBlank(String carNames, String raceRounds) {
        return carNames.isBlank() || raceRounds.isBlank();
    }
}
