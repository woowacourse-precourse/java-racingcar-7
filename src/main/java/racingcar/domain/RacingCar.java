package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.validator.RacingCarValidator;

public class RacingCar {
    private String carName;
    private Integer advanceRecord;
    private static final Integer INITIAL_ADVANCE_RECORD = 0;
    private static final Integer START_RANDOM_VALUE = 0;
    private static final Integer END_RANDOM_VALUE = 9;
    private static final Integer ADVANCE_STANDARD = 4;
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

    public void tryToAdvance() {
        if (canAdvance()) {
            advanceRecord++;
        }
    }

    private boolean canAdvance() {
        return pickNumberInRange(START_RANDOM_VALUE, END_RANDOM_VALUE) >= ADVANCE_STANDARD;
    }
}
