package racingcar.util;

public class Validator {
    public static void carName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자까지 입력 가능합니다.");
        }
    }

    public static int rounds(String input) {
        try {
            int rounds = Integer.parseInt(input);
            if (rounds < 1) {
                throw new IllegalArgumentException("잘못된 이동 횟수입니다. 양의 정수를 입력해주세요.");
            }

            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 이동 횟수입니다. 양의 정수를 입력해주세요.");
        }
    }
}
