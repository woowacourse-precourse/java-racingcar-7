package racingcar.factory;

import java.util.Arrays;
import java.util.List;

public class NamingProcessor {

    private static final String NAME_DELIMITER = ",";

    public NamingProcessor() {
    }

    public List<String> separateName(String namingInput) {
        if (isInvalid(namingInput)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(namingInput.split(NAME_DELIMITER))
                .map(String::trim)
                .toList();
    }

    private boolean isInvalid(String namingInput) {
        return namingInput == null || namingInput.trim().isEmpty();
    }

}
