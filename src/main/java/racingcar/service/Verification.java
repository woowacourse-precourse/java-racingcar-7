package racingcar.service;

public class Verification {
    public static void verifyCarNames(String[] carNames) {

        for (String carName : carNames) {// 자동차 이름 검증
            System.out.println(carName);
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

    public void special_characters(String carNames) { // 특수문자 검증
        if (!carNames.matches(".*[!@#$%^&*().?\":{}|<>a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("자동차 이름 구분에는 쉼표만 가능합니다.");
        }
    }

    public int Round(String round) {  // 라운드 검증
        try {
            int roundInt = Integer.parseInt(round);
            if (roundInt <= 0) {
                throw new IllegalArgumentException("라운드는 0보다 작거나 같으면 안됩니다.");
            }
            return roundInt;
        } catch (NumberFormatException e) { // 숫자가 아닌 문자가 입력되었을 때
            throw new IllegalArgumentException("라운드는 숫자로 입력해 주세요.");
        }
    }
}
