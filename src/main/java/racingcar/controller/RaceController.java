package racingcar.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<String> players = playerService.splitPlayer(input);
        raceModel.setPlayers(players);
        int raceCount = InputView.inputRaceCount();
        raceModel.setRaceCount(raceCount);
        initData(players.size());
    }

    private void initData(int count) {
        List<Integer> progress = new ArrayList<>(Collections.nCopies(count, 0));
        raceModel.setProgress(progress);
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
            raceService.race(raceModel.getProgress());
            outputProgress();
        }
    }

    private void findWinner() {
        raceService.findWinner(raceModel.getPlayers(), raceModel.getProgress(), raceModel.getWinners());
    }

    private void outputProgress() {
        OutputView.printRaceResult(raceModel.getPlayers(), raceModel.getProgress());
    }

    private void outputWinner() {
        OutputView.printWinner(raceModel.getWinners());
    }
}
