package racingcar;

public class NamesInputValidator {

    public static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다");
        }
        String[] tokens = input.split(",");
        if (tokens.length <= 1) {
            throw new IllegalArgumentException("차는 최소 2대 이상이어야 합니다");
        }
        for (String token: tokens) {
            String name = token.strip();
            if (name.length() > 5) {
                throw new IllegalArgumentException("차 이름은 5자를 초과할 수 없습니다");
            }
        }
    }
}
