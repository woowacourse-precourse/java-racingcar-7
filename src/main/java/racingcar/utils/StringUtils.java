package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public List<String> separateName(String nameString) {
        try {
            return Arrays.stream(nameString.split(","))
                    .peek(this::validateName)
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    private void validateName(String name) {
        if (name.length() > ConstantNumber.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ConstantMessage.NAME_LENGTH_EXCEPTION);
        }
    }
}
