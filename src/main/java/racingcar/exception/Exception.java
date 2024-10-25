package racingcar.exception;

public class Exception {

    private static final String MESSAGE_UNDER_CARS = "[ERROR] 자동차를 2대 이상 입력해주세요";
    private static final String MESSAGE_NAME_EMPTY = "[ERROR] 자동차 이름을 빈 공간으로 입력했습니다";
    private static final String MESSAGE_NAME_OVER_FIVE = "[ERROR] 자동차 이름을 5글자 이상으로 입력했습니다";
    private static final String MESSAGE_NAME_DUPLICATE = "[ERROR] 자동차 이름이 중복되었습니다";

    public static void exceptionUnderCars() {
        throw new IllegalArgumentException(MESSAGE_UNDER_CARS);
    }

    public static void exceptionNameEmpty() {
        throw new IllegalArgumentException(MESSAGE_NAME_EMPTY);
    }

    public static void exceptionNameOverFive() {
        throw new IllegalArgumentException(MESSAGE_NAME_OVER_FIVE);
    }

    public static void exceptionNameDuplicate() {
        throw new IllegalArgumentException(MESSAGE_NAME_DUPLICATE);
    }
}
