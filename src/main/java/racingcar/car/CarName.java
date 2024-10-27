package racingcar.car;

public class CarName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String content;

    public CarName(final String rawContent) {
        String content = rawContent.strip();
        validateContentLength(content);
        validateContent(content);
        this.content = content;
    }

    private void validateContentLength(final String content) {
        validateMinLength(content);
        validateMaxLength(content);
    }

    private void validateMaxLength(final String content) {
        if (content.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_LENGTH + "자 이하여야 합니다.");
        }
    }

    private void validateMinLength(final String content) {
        if (content.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MIN_LENGTH + "자 이상이어야 합니다.");
        }
    }

    private void validateContent(final String content) {
        if (isOnlyContainNumber(content)) {
            throw new IllegalArgumentException("이름은 숫자로만 구성될 수 없습니다. 최소 1자 이상의 문자를 포함해주세요.");
        }
    }

    private boolean isOnlyContainNumber(final String content) {
        int countOfNumber = 0;
        String removedWhiteSpace = content.replace(" ", "");
        for (char c : removedWhiteSpace.toCharArray()) {
            if (c >= '1' && c <= '9') {
                countOfNumber++;
            }
        }
        return removedWhiteSpace.length() == countOfNumber;
    }

    public String getContent() {
        return content;
    }
}
