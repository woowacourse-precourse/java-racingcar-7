package racingcar;

public class MoveCountValidator {

    // 두 번째 기능: 이동 횟수 입력 및 정수 검증
    public static int getMoveCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // 정수 아닌 경우 예외 발생
        }
    }
}
