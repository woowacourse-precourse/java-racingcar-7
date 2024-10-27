package racingcar;

public class NamesInputValidator {

    public static void validate(String input) {
        String[] tokens = input.split(",");
        for (String token: tokens) {
            String name = token.strip();
            if (name.length() > 5) {
                throw new IllegalArgumentException("차 이름은 5자를 초과할 수 없습니다");
            }
        }
    }
}
