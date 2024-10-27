package racingcar.service;

public class Validate {

    public static String[] validateCarNames (String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        String[] carNamesList = carNames.split(",");
        for (String carName : carNamesList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름이 6자 이상입니다.");
            }
        }
        return carNamesList;
    }

    public static int validateTryNumber (String tryNumber) {
        if (tryNumber.isBlank()) {
            throw new IllegalArgumentException("게임 횟수를 입력해주세요.");
        }
        try {
            return Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

}
