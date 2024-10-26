package racingcar.utils;

public class InputValidator {
    public static void inputCarsNameValidation(String inputCarsName){
        if (inputCarsName.isBlank()) {
            throw new IllegalArgumentException("빈 공백은 자동차 이름이 될 수 없습니다. 자동차 이름을 입력해주세요.");
        }
    }

    public static void tryNumberValidation(String tryNumberString){
        try {
            Integer tryNumber = Integer.valueOf(tryNumberString);
            if (tryNumber <= 0) {
                throw new IllegalArgumentException("횟수 입력은 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수입니다. 양의 정수를 입력해 주세요.");
        }
    }
}
