package racingcar.model;

import java.util.Arrays;
import java.util.List;

import static racingcar.constants.ErrorMessage.NOT_ALLOWED_FIRST_LAST_BLANK;

public class CarNames {
    private final String rawCarNames;

    public CarNames(final String rawCarNames) {
        validate(rawCarNames);
        this.rawCarNames = rawCarNames;
    }

    public List<String> splitByComma() {
        return Arrays.stream(rawCarNames.split(","))
                .toList();
    }

    private void validate(final String rawCarNames) {
        validateStrip(rawCarNames);
    }

    private void validateStrip(final String rawCarNames) {
        String stripped = rawCarNames.strip();
        if (stripped.equals(rawCarNames)) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_FIRST_LAST_BLANK);
    }
}
