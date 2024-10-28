package racingcar.exception;

public class CarNameValidator {

    public static void nameTooLong() {
        throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
    }

    public static void blankName() {
        throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
    }

    public static void invalidCharacters() {
        throw new IllegalArgumentException("이름은 영어 문자만 가능합니다.");
    }

    public static void duplicateName() {
        throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
    }
}
