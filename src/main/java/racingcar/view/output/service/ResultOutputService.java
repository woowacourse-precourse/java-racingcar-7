package racingcar.view.output.service;

import racingcar.racingcar.service.racing.dto.RacingResult;


public interface ResultOutputService {
    void executionResults(RacingResult racingResult);
    void winningCarsStatistic(String winningCars);
}
