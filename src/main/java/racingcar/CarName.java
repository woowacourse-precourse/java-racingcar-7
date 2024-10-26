package racingcar;

public class CarName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String content;

    public CarName(final String rawContent) {
        String content = rawContent.strip();
        validateContentLength(content);
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

    public String getContent() {
        return content;
    }
}
