package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputProcessor inputProcessor;
    private final GameService gameService;

    private final Race race;


    public CarRaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputProcessor = new InputProcessor();
        this.gameService = new GameService();
        this.race = new Race();
    }

    public void run() {
        prepareRace();
        startRace();
        getFinalWinners();
    }

    private void prepareRace() {
        String stringCarList = inputView.getCarNames();
        String stringMoveCount = inputView.getMoveCount();

        inputProcessor.setCarList(race, stringCarList);
        inputProcessor.setTotalRound(race, stringMoveCount);
    }

    private void startRace() {
        System.out.println("실행 결과");

        for (int i = 0; i < this.race.getTotalRound(); i++) {
            gameService.playRound(race);
            outputView.printRoundResult(race);
        }
    }

    private void getFinalWinners() {
        List<Car> finalWinners = gameService.getFinalWinners(this.race);
        outputView.printFinalWinners(finalWinners);
    }

}
