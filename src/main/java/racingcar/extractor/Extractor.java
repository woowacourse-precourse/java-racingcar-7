package racingcar.extractor;

public interface Extractor<T> {

    T extract(String input);

    default void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    default void checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열과 공백은 입력할 수 없습니다.");
        }
    }

    void validateInput(String input);
}
