package racingcar.utils;

import java.util.ArrayList;

public class Validator {
    public void validateInputCarName(ArrayList<String> carNames) {
        for(String car : carNames){
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public void validateInputGameCount(String gameCount) {
        if(!isValidNumber(gameCount)) {
            throw new IllegalArgumentException("게임 횟수는 숫자로 입력하여야 합니다.");
        }
        if(Integer.parseInt(gameCount) < 0) {
            throw new IllegalArgumentException("게임 횟수는 양수만 입력할 수 있습니다.");
        }
    }

    private boolean isValidNumber(String gameCount) {
        try {
            Integer.parseInt(gameCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
