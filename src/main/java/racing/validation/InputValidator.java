package racing.validation;

public class InputValidator {
    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
    public void validateGameRound(int roundCnt) {
        if (roundCnt < 1) {
            throw new IllegalArgumentException("게임 횟수는 1이상 부터 가능합니다");
        }
    }
}
