package racingcar.domain.car;

import java.util.List;

public record CarName(String name) {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String REQUIRE_NAME_MESSAGE = "자동차의 이름은 필수입니다.";
    private static final String NAME_LENGTH_EXCEED_MESSAGE = String.format("자동차의 이름은 %d글자 이하만 가능합니다.", MAX_NAME_LENGTH);

    public CarName(String name) {
        validateNullName(name);
        String trimName = name.trim();
        validateName(trimName);
        this.name = trimName;
    }

    public static List<CarName> listOf(List<String> carNames) {
        return carNames.stream()
                .map(CarName::new)
                .toList();
    }

    private static void validateNullName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(REQUIRE_NAME_MESSAGE);
        }
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(REQUIRE_NAME_MESSAGE);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEED_MESSAGE);
        }
    }
}
