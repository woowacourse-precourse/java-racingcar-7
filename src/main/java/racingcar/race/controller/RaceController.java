package racingcar.race.controller;

import java.util.List;
import racingcar.car.model.Car;
import racingcar.race.service.RaceService;
import racingcar.view.Input;
import racingcar.view.Output;


// 경주 전체를 제어하는 컨트롤러
public class RaceController {
    private final RaceService raceService;
    private final Input input;
    private final Output output;

    public RaceController(RaceService raceService, Input input, Output output) {
        this.raceService = raceService;
        this.input = input;
        this.output = output;
    }

    public void startRace() {
        raceService.startRace(input.getCarNames(), input.getAttemptCount());
        List<Car> winners = raceService.getWinners();
        output.printWinners(winners);
    }
}
