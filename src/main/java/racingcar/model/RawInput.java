package racingcar.model;

public record RawInput(String rawInput) {
    public static RawInput of(String rawInput) {
        return new RawInput(rawInput);
    }
}
