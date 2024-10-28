package racingcar;

import java.util.Set;

public class Validater {
    public static void validateCarNames(String[] carNames){
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

    private static void validateCarNameLength(String[] carNames) {
        for (String carName : carNames){
            if (carName.length() > 5){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void validateDuplicateCarName(String[] carNames) {
        try {
            Set<String> carNamesSet = Set.of(carNames);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 입력 불가능합니다.");
        }
    }

    private static void validateCarsCount(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 하나 이상 입력해야 합니다.");
        }
    }


}
