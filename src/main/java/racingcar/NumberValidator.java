package racingcar;

public class NumberValidator {
    public void inputPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("시도할 횟수를 양수로 입력해주세요");
        }
    }
}
