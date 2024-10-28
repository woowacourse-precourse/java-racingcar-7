package controller;

import service.RaceService;
import service.RandomMoveStrategy;
import view.Input;
import view.Output;

import java.util.List;

public class RaceController {
    public void run() {
        List<String> carNames = Input.getCarNames();
        int attempts = Input.getAttempts();
        Input.closeConsole();

        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        RaceService raceService = new RaceService(carNames, attempts, randomMoveStrategy);

        Output.printRaceStart();
        raceService.startRace(Output::printRaceStatus);
        Output.printWinners(raceService.getWinners());
    }
}
