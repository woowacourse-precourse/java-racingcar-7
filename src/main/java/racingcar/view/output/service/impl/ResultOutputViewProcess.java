package racingcar.view.output.service.impl;

import racingcar.racingcar.service.racing.dto.RacingResult;
import racingcar.view.output.service.ResultOutputService;

public class ResultOutputViewProcess implements ResultOutputService {
    @Override
    public void executionResults(RacingResult racingResult) {
        System.out.println("실행 결과");
        System.out.print(racingResult);
    }

    @Override
    public void winningCarsStatistic(String winningCars) {
        System.out.printf("최종 우승자 : %s", winningCars);
    }
}
