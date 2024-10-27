package racingcar.model;

public record TryCountDto(String input) {



    public TryCountDto {
        validate(input);
    }

    private void validate(String input) {
        validateEmpty(input);
        validateNumeric(input);
    }

    private void validateEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수에 빈 값을 입력할 수 없습니다.");
        }
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
}
