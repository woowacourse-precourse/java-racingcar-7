package racingcar;

public class Validator {
    protected void validMinus(Integer input) {

        int attempts = Integer.parseInt(String.valueOf(input));
        if (attempts <= 0) {  // 음수 및 0 입력에 대한 예외 처리
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    protected void fiveChar(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    protected void blankName(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
    }
}
