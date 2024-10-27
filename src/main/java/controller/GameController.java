package controller;

import java.util.List;
import model.Car;
import service.RacingCarService;
import view.OutputView;

public class GameController {
    private final RacingCarService racingCarService;
    private final OutputView outputView;

    public GameController(RacingCarService racingCarService, OutputView outputView) {
        this.racingCarService = racingCarService;
        this.outputView = outputView;
    }

    public void startGame(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            racingCarService.playRound(cars);
            outputView.printRaceStatus(cars);
        }
    }

    public void announceWinners(List<Car> cars) {
        List<String> winners = racingCarService.findFinalWinners(cars);
        outputView.printFinalWinner(winners);
    }
}
