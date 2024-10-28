package racingcar;

public class NumberValidator {
    public void inputPositiveNumber(int number) {
        if (isNegativeNumber(number)) {
            throw new IllegalArgumentException("시도할 횟수를 양수로 입력해주세요");
        }
    }

    private boolean isNegativeNumber(int number) {
        return number <= 0;
    }
}
