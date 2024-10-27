package racingcar.service.racing.impl;
import racingcar.constant.separator.SeparatorConstant;
import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;

import java.util.stream.Collectors;


public class WinningCar {
    private final RacingResultCalculator racingResultCalculator;
    public WinningCar(RacingResultCalculator racingResultCalculator) {
        this.racingResultCalculator = racingResultCalculator;
    }
    public String WinningCarsResult(RacingCarInfo racingCarInfo) {
        int firstPlaceMove = racingResultCalculator.calculateFirstPlaceMove(racingCarInfo);
        return racingCarInfo.getRacingCarInfo().stream()
                .filter((racingCar) -> racingCar.getMove() == firstPlaceMove)
                .map(RacingCar::getName)
                .collect(Collectors.joining(SeparatorConstant.COMMA + SeparatorConstant.SPACE));
    }
}
