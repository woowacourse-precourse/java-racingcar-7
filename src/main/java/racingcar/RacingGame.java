package racingcar;

public class RacingGame {
    public RacingGame(String carNamesInput, int trialCount) {
        validateCarNames(carNamesInput);

    }

    private void validateCarNames(String carNamesInput) {
        for (String name : carNamesInput.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void start() {
    }
}
