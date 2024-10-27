package racingcar.service;

public class Verification {
    public static void verifyCarNames(String[] carNames) {

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }

            else if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
            }

            else if (carName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
            }
        }

    }

    public void special_characters(String carNames) {
        if (!carNames.matches(".*[!@#$%^&*().?\":{}|<>a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("자동차 이름 구분에는 쉼표만 가능합니다.");
        }
    }
}
