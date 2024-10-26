package racingcar.ui;

import static racingcar.ui.InputError.DUPLICATE_NAME;
import static racingcar.ui.InputError.NAME_CANNOT_BE_BLANK;
import static racingcar.ui.InputError.NAME_LENGTH_OVER;
import static racingcar.ui.InputError.TRY_COUNT_MUST_BE_POSITIVE;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class InputParser {

    private final String delimiter;

    public InputParser(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<String> parseNames(String names) {
        List<String> splitNames = Arrays.stream(names.split(delimiter)).toList();
        validateNameFormat(splitNames);
        validateDuplicateName(splitNames);
        return splitNames;
    }

    public int parseTryCount(String stringTryCount) {
        try {
            int tryCount = Integer.parseInt(stringTryCount);
            isPositiveNum(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_MUST_BE_POSITIVE.getMessage());
        }
    }

    private void validateNameFormat(List<String> splitNames) {
        for (String name : splitNames) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(NAME_CANNOT_BE_BLANK.getMessage());
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException(NAME_LENGTH_OVER.getMessage());
            }
        }
    }

    private void validateDuplicateName(List<String> splitNames) {
        Set<String> nameSet = Set.copyOf(splitNames);

        if (splitNames.size() != nameSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
        }
    }

    private void isPositiveNum(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(TRY_COUNT_MUST_BE_POSITIVE.getMessage());
        }
    }
}
