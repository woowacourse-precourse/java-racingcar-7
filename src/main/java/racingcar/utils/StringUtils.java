package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUtils {
    public List<String> separateName(String nameString) {
        try {
            List<String> nameList = Arrays.stream(nameString.split(","))
                    .peek(this::validateNameLength)
                    .collect(Collectors.toList());

            validateNameDuplication(nameList);
            return nameList;
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > ConstantNumber.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ConstantMessage.NAME_LENGTH_EXCEPTION);
        }
    }

    private void validateNameDuplication(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() < names.size()) {
            throw new IllegalArgumentException(ConstantMessage.DUPLICATED_NAME_EXCEPTION);
        }
    }
}
