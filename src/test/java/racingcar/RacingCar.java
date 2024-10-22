package racingcar;

public class RacingCar {

    String[] separateCarNames(String inputString) {
        if (!inputString.contains(",")) {
            throw new IllegalArgumentException("구분자가 없습니다.");
        }

        return inputString.split(",");
    }
}
