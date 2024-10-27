package racingcar;

public class InputValidator {
    private static final int NAME_MAX_LENGTH = 5;

    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
            }
        }
    }

    public static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }
}
