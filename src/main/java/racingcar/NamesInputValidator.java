package racingcar;

public class NamesInputValidator {

    public static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new CustomException(ExceptionCode.INPUT_BLANK);
        }
        String[] tokens = input.split(",");
        if (tokens.length <= 1) {
            throw new CustomException(ExceptionCode.CAR_SHORTAGE);
        }
        for (String token: tokens) {
            String name = token.strip();
            if (name.length() > 5) {
                throw new CustomException(ExceptionCode.NAME_TOO_LONG);
            }
        }
    }
}
