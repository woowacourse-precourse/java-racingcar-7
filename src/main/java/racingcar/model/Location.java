package racingcar.model;

import racingcar.validator.BasicValidator;
import racingcar.validator.LocationValidator;

public record Location(int location) {

    private static final BasicValidator<Integer> locationValidator = new LocationValidator();

    public Location {
        locationValidator.validate(location);
    }
}