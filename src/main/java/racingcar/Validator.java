package racingcar;

public class Validator {

    public static void checkCarNames(String[] carNames) {
        for(String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자리 이하만 가능합니다.");
            }
        }
    }

    public static void checkRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

}
