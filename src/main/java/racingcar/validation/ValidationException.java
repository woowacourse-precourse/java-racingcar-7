package racingcar.validation;

/**
 * packageName    : racingcar.validation
 * fileName       : ValidationException
 * author         : ehgur
 * date           : 2024-10-25
 * description    : 유효성 검사 예외 처리 로직
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25        ehgur             최초 생성
 */

public class ValidationException {

    private static final int NAME_LENGTH_LIMIT = 5;

    public static void isCarNameLengthValid(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public static void isEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
