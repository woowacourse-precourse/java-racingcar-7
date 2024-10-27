package racingcar;

public class InputValidator {
    public static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name == null || name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateNumberOfRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }
}
