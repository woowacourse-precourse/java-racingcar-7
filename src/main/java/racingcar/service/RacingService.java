package racingcar.service;

import racingcar.common.StringUtil;
import racingcar.domain.Cars;
import racingcar.endpoint.OutputInterface;

public class RacingService {
    private final Cars cars;

    public RacingService(Cars cars) {
        this.cars = cars;
    }

    public void playGame(String secondLine) {
        Long count = StringUtil.parseToNumeric(secondLine);
        loopEachCycle(count);
        OutputInterface.printMessage(OutputInterface.FINAL_WINNER+cars.getWinnersName());
    }

    private void loopEachCycle(Long count) {
        OutputInterface.printMessage(OutputInterface.EXECUTION_RESULT);
        for (int i = 0; i < count; i++) {
            cars.progressRace();
            OutputInterface.printMessage(cars.toPrettyString());
        }
    }
}
