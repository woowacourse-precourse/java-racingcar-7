package racingcar.validation;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.constant.ErrorMessage;
import racingcar.model.Racer;

public class RacerValidator implements Validator {
    @Override
    public Class<?> supportsType() {
        return Racer.class;
    }

    @Override
    public void validate(Object target) {
        String value = (String) target;
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_PARTICIPANTS_ERROR);
        }

        Set<String> racerUniqueName = Arrays.stream(value.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());

        if (racerUniqueName.size() != value.split(",").length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_ERROR);
        }
    }
}
