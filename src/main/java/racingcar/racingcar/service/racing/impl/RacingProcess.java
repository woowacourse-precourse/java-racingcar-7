package racingcar.racingcar.service.racing.impl;

import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.service.move.MoveService;
import racingcar.racingcar.service.racing.RacingService;
import racingcar.racingcar.service.racing.dto.RacingResult;
import racingcar.trynumber.domain.TryNumber;
import racingcar.view.output.service.ResultOutputService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingProcess implements RacingService {
    private final MoveService moveProcess;
    private final WinningCar winningCar;
    private final ResultOutputService resultOutputViewProcess;

    public RacingProcess(MoveService moveProcess, WinningCar winningCar, ResultOutputService resultOutputViewProcess) {
        this.moveProcess = moveProcess;
        this.winningCar = winningCar;
        this.resultOutputViewProcess = resultOutputViewProcess;
    }

    @Override
    public void racing(RacingCarInfo racingCarInfo, TryNumber tryNumber) {
        resultOutputViewProcess.executionResults(executeRace(racingCarInfo, tryNumber));
        resultOutputViewProcess.winningCarsStatistic(winningCarStatistic(racingCarInfo));
    }
    private String winningCarStatistic(RacingCarInfo racingCarInfo) {
        return winningCar.WinningCarsResult(racingCarInfo);
    }

    private String move(RacingCarInfo racingCarInfo) {
        return moveProcess.move(racingCarInfo);
    }
    private RacingResult executeRace(RacingCarInfo racingCarInfo, TryNumber tryNumber) {
        return Stream.generate(() -> move(racingCarInfo))
                .limit(tryNumber.getCount())
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingResult::new));
    }
}