package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        List<String> carNames = InputView.getCarNames();
        int moveCount = InputView.getMoveCount();

        List<RacingCar> winners = racingCarService.logic(carNames, moveCount);
        String winnerNames = winners.stream().map(RacingCar::getCarName).collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
