package racingcar.validator;
public class InputValidator {

    private static final String CAR_NAME_REGEX = "^[a-z]{1,5}$"; // 이름 유효성 검사 정규 표현식
    private static final int MAX_CARS = 10;
    private static final int MIN_ROUNDS = 1;
    private static final int MAX_ROUNDS = 100;

    public void validateCarNames(String input) {
        String[] carNames = input.split(",");

        if (carNames.length < 1 || input.isEmpty()) {
            throw new IllegalArgumentException("최소 1개 이상의 자동차 이름을 입력해야 합니다.");
        }
        if (carNames.length > MAX_CARS) {
            throw new IllegalArgumentException("최대 경주자 수는 " + MAX_CARS + "명입니다.");
        }

        for (String name : carNames) {
            if (!name.matches(CAR_NAME_REGEX)) {
                throw new IllegalArgumentException("자동차 이름은 1~5자의 소문자 알파벳으로 이루어져야 합니다.");
            }
        }
    }

    public void validateRounds(String input) {
        try {
            if (input.isEmpty()) throw new IllegalArgumentException("이동횟수는 공백일 수 없습니다.");
            int rounds = Integer.parseInt(input);
            if (rounds < MIN_ROUNDS || rounds > MAX_ROUNDS) {
                throw new IllegalArgumentException("이동 횟수는 1 이상 100 이하의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
        }
    }
}

