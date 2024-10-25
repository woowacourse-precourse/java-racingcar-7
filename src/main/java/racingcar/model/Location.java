package racingcar.model;

import racingcar.validator.BasicValidator;
import racingcar.validator.LocationValidator;

public record Location(int location) {

    private static final int START_LOCATION = 0;

    private static final BasicValidator<Integer> locationValidator = new LocationValidator();

    public Location {
        locationValidator.validate(location);
    }

    public static Location init() {
        return new Location(START_LOCATION);
    }
}