package racingcar.view.input;

public abstract class InputView {

    public String inputCarNames() {
        final String input = inputCarNamesString();
        validateNotBlank(input);
        return input;
    }

    protected abstract String inputCarNamesString();

    public String inputNumberOfAttempts() {
        final String input = inputNumberOfAttemptsString();
        validateNotBlank(input);
        return input;
    }

    protected abstract String inputNumberOfAttemptsString();

    private void validateNotBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력이 null이거나 빈 문자열일 수 없습니다.");
        }
    }
}
