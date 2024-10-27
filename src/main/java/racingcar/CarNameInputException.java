package racingcar;

public class CarNameInputException extends IllegalArgumentException {
    public CarNameInputException() {
        System.out.println("자동차 이름의 글자 수는 1 이상 5 이하만 가능합니다.");
    }
}
