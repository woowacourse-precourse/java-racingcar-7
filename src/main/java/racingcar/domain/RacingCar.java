package racingcar.domain;

import racingcar.validator.RacingCarValidator;

public class RacingCar {
    private String carName;
    private Integer advanceRecord;
    private static final Integer INITIAL_ADVANCE_RECORD = 0;
    private final RacingCarValidator racingCarValidator = new RacingCarValidator();

    public RacingCar(String carName) {
        racingCarValidator.validateCarName(carName);
        this.carName = carName;
        this.advanceRecord = INITIAL_ADVANCE_RECORD;
    }

    public String getCarName() {
        return carName;
    }

    public Integer getAdvanceRecord() {
        return advanceRecord;
    }
}
