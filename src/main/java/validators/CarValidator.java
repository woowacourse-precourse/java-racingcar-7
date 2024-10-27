package validators;

import static constant.ErrorValidators.NAME_EMPTY;
import static constant.ErrorValidators.NAME_LONGER;
import static constant.ErrorValidators.NAME_OVERLAP;
import static constant.GameSettings.NAME_MAX;

import java.util.Set;

public class CarValidator {

    public static void validateCarName(String name, Set<String> uniqueNames) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(NAME_EMPTY.getMessage());
        }
        if (name.length() > NAME_MAX.getMessage()) {
            throw new IllegalArgumentException(NAME_LONGER.getMessage());
        }
        if (!uniqueNames.add(name)) {
            throw new IllegalArgumentException(NAME_OVERLAP.getMessage() + name);
        }
    }
}
