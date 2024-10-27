package racingcar;

public class ExceptionHandler {
    public static void validateCarNameLength (String name){
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 입력해주세요. : " + name);
        }
    }

    public static void validateDuplicateCarName (int carsNameLength, int uniqueCarsNameLength) {
        if (carsNameLength != uniqueCarsNameLength) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateMoveCount (int moveCount) {
        if (moveCount == 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
    }

    public static int parseIntOrThrow (String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalThreadStateException("입력된 시도 횟수가 숫자가 아닙니다. : " + inputNumber);
        }

        return Integer.parseInt(inputNumber);
    }
}
