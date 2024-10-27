package racingcar.service.racing.impl;

import racingcar.constant.errormessage.ErrorMessage;
import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;
public class RacingResultCalculator {

    public int calculateFirstPlaceMove(RacingCarInfo racingCarInfo) {
        return racingCarInfo.getRacingCarInfo().stream()
                .mapToInt(RacingCar::getMove)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR));
    }
}
