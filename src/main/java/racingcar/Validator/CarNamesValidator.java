package racingcar.Validator;

import racingcar.Separator;

import java.util.HashSet;
import java.util.Set;

public class CarNamesValidator {

    public void separateByComma(String carNames) {
        if (!isCommaSeparated(carNames)) {
            throw new IllegalArgumentException("쉼표(,)로 구분하여 자동차 이름들을 입력해주세요");
        }
    }

    public void inputMoreThanTwo(String carNames) {
        if (!isMoreThanTwo(Separator.split(carNames))) {
            throw new IllegalArgumentException("자동차 이름을 두 개 이상으로 입력해주세요");
        }
    }

    public void inputSameName(String carNames) {
        Set<String> set = new HashSet<>();
        for (String carName : Separator.split(carNames)) {
            checkSameName(carName, set);
        }
    }

    private void checkSameName(String carName, Set<String> set) {
        if(isSameName(carName, set)) {
            throw new IllegalArgumentException("중복되지 않는 이름을 입력해주세요");
        }
    }

    private boolean isCommaSeparated(String carNames) {
        return carNames.matches("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$");
    }

    private boolean isMoreThanTwo(String[] carNameArray) {
        return carNameArray.length >= 2;
    }

    private boolean isSameName(String carName, Set<String> set) {
        return !set.add(carName);
    }
}
