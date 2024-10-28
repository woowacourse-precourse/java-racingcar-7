package racingcar.service;

public class Validate {
    public static String[] validateCarNames (String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        String[] carNamesList = carNames.split(",");
        for (String carName : carNamesList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름이 6자 이상입니다.");
            } else if (carName.isBlank()) {
                throw new IllegalArgumentException("이름을 입력해주세요.");
            }
        }
        return carNamesList;
    }

    public static int validateTryNumber (String tryNumber) {
        int tryNumberToInt;
        if (tryNumber.isBlank()) {
            throw new IllegalArgumentException("게임 횟수를 입력해주세요.");
        }
        try {
            tryNumberToInt = Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
        if (tryNumberToInt <= 0) {
            throw new IllegalArgumentException("1이상의 숫자를 입력해주세요.");
        }
        return tryNumberToInt;
    }
}
