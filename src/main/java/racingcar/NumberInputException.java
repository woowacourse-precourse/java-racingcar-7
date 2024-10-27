package racingcar;

public class NumberInputException extends IllegalArgumentException {
    public NumberInputException() {
        System.out.println("음수는 입력할 수 없습니다.");
    }
}
