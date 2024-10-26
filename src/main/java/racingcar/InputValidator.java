package racingcar;

public class InputValidator {
    public static void nameValidation(String carName) {
        if (carName == null || carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능 합니다.");
        }
    }

    public static void tryNumberValidation(int tryNumber) {
        if(tryNumber <= 0) {
            throw new IllegalArgumentException("게임의 시도 횟수는 1회 이상 입력 되어야 합니다.");
        }
    }
}
