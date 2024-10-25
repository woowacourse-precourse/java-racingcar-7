package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceModel;
import racingcar.service.PlayerService;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final RaceModel raceModel;
    private final PlayerService playerService;
    private final RaceService raceService;

    public RaceController() {
        this.raceModel = RaceModel.getInstance();
        this.raceService = new RaceService();
        this.playerService = new PlayerService();
    }

    public void input() {
        String input = InputView.inputPlayer();
        List<String> playerNames = playerService.splitPlayer(input);
        int raceCount = InputView.inputRaceCount();
        initData(playerNames, raceCount);
    }

    private void initData(List<String> playerNames, int raceCount) {
        List<Car> cars = playerService.createCarList(playerNames);
        raceModel.setCars(cars);
        raceModel.setRaceCount(raceCount);
        raceModel.setWinners(new ArrayList<>());
    }

    public void startRace() {
        input();
        race();
        findWinner();
        outputWinner();
    }

    private void race() {
        for (int i = 0; i < raceModel.getRaceCount(); i++) {
            raceService.race(raceModel.getCars());
            outputProgress();
        }
    }

    private void findWinner() {
        raceService.findWinner(raceModel.getCars(), raceModel.getWinners());
    }

    private void outputProgress() {
        OutputView.printRaceResult(raceModel.getCars());
    }

    private void outputWinner() {
        OutputView.printWinner(raceModel.getWinners());
    }
}
