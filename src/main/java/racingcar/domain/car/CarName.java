package racingcar.domain.car;

public record CarName(String name) {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String REQUIRE_NAME_MESSAGE = "자동차의 이름은 필수입니다.";
    private static final String NAME_LENGTH_EXCEED_MESSAGE = String.format("자동차의 이름은 %d글자 이하만 가능합니다.", MAX_NAME_LENGTH);

    public CarName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(REQUIRE_NAME_MESSAGE);
        }

        String trimName = name.trim();
        validate(trimName);
        this.name = trimName;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(REQUIRE_NAME_MESSAGE);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEED_MESSAGE);
        }
    }
}
