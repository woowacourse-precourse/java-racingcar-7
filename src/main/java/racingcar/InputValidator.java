package racingcar;

public class InputValidator {

    private static final char NAME_DELIMITER = ',';

    public void validateNameFormat(String names) {
        for(char ch : names.toCharArray()) {
            if(isValidNameCharacter(ch)) {
                continue;
            }

            throw new IllegalArgumentException("이름은 쉼표 기준으로 구분할 수 있습니다.");
        }
    }

    private boolean isValidNameCharacter(char ch) {
        return Character.isLetterOrDigit(ch) || ch == NAME_DELIMITER;
    }
}
