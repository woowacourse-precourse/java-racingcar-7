package racingcar.dto;

public record RawCarNamesInput(
        String rawCarNames
) {
    public static RawCarNamesInput of(String rawCarNames) {
        return new RawCarNamesInput(rawCarNames.stripLeading().stripTrailing());
    }
}
