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
}
