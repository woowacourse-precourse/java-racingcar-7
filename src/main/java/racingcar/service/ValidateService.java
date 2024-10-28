package racingcar.service;

import java.util.*;

import static racingcar.util.ConditionConstant.MAX_LENGTH;
import static racingcar.util.ErrorMessage.*;

public class ValidateService {


    public List<String> validateName(String names) {
        List<String> validatedNames = new ArrayList<>();

        List<String> rawNames = Arrays.stream(names.split(",")).toList();

        validateBlankInput(rawNames);

        rawNames.forEach(rawName -> {
            String trimmedName = rawName.trim();

            validateBlankInput(trimmedName);

            validateNameLength(trimmedName);

            validatedNames.add(trimmedName);
        });
        return validatedNames;
    }

    public List<String> validateDuplicateNames(List<String> processingName) {
        Set<String> nameSet = new HashSet<>();
        for (String name : processingName) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
            }
        }
        return processingName;
    }

    public void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    public long validateRaceCount(String raceCount) {
        String trimmedRaceCount = raceCount.trim();

        validateBlankInput(raceCount);

        return validateNumber(trimmedRaceCount);

    }

    private long validateNumber(String trimmedRaceCount) {
        try {
            int rawRaceCount = Integer.parseInt(trimmedRaceCount);

            if (rawRaceCount <= 0) {
                throw new IllegalArgumentException();
            }
            return rawRaceCount;
        } catch (Exception e) {
            // 음수 확인, 숫자로 변경 할 수 없을 경우
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_INPUT);
        }
    }

    private void validateBlankInput(List<String> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK_INPUT);
        }
    }

    private void validateBlankInput(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK_INPUT);
        }
    }

}
