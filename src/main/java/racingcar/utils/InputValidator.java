package racingcar.utils;

public class InputValidator {
    public static void inputCarsNameValidation(String inputCarsName){
        if (inputCarsName.isBlank()) {
            throw new IllegalArgumentException("빈 공백은 자동차 이름이 될 수 없습니다. 자동차 이름을 입력해주세요.");
        }
    }

}
