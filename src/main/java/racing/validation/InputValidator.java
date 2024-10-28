package racing.validation;

import java.util.List;

public class InputValidator {
    public void validateCarNames(List<String> carNames) {

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 유효 하지않습니다.");
        }
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }
    public void validateGameRound(int roundCnt) {
        if (roundCnt < 1) {
            throw new IllegalArgumentException("게임 횟수는 1이상 부터 가능합니다");
        }
    }

    public void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 유효 하지않습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
