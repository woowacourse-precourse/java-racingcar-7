package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validater {
    public static void validateCarNames(List<String> carNames){
        validateCarsCount(carNames);
        validateCarNameLength(carNames);
        validateDuplicateCarName(carNames);
    }

    public static void validateRaceCount(String userInputCount){
        char[] tmp = userInputCount.toCharArray();
        for (char c : tmp) {
            if (!(c >= '0' && c <= '9')){
                throw new IllegalArgumentException("[ERROR] 실행 횟수는 숫자여야 합니다");
            }
        }
    }

    private static void validateCarNameLength(List<String> carNames) {
        for (String carName : carNames){
            if (carName.length() > 5){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void validateDuplicateCarName(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNamesSet.size() != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 입력 불가능합니다.");
        }
    }

    private static void validateCarsCount(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 하나 이상 입력해야 합니다.");
        }
    }


}
