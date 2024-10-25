package racingcar.controller;

import java.util.List;
import racingcar.model.GameCoinInput;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarManager;
import racingcar.model.RacingCarNameInput;
import racingcar.model.WinnerFinder;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    RacingCarManager racingCarManager;

    public RacingGame() {
        racingCarManager = new RacingCarManager();
    }

    public void play() {
        settingRacingCars();
        int gameCoin = getGameCoin();
        playingRounds(gameCoin);
        showWinner();
    }

    private void settingRacingCars() {
        OutputView.startingMessage();
        RacingCarNameInput racingCarNameInput = new RacingCarNameInput(InputView.readLine());
        List<String> nameList = racingCarNameInput.getRacingCarNameList();
        for (String name : nameList) {
            racingCarManager.newCar(new RacingCar(name));
        }
    }

    private int getGameCoin() {
        OutputView.insertCoinMessage();
        GameCoinInput gameCoinInput = new GameCoinInput(InputView.readLine());
        return gameCoinInput.getGameCoin();
    }

    private void playingRounds(int coins) {
        OutputView.middlePrintMessage();

        while (coins > 0) {
            racingCarManager.playRound();
            showRoundResult();
            OutputView.emptyLine();
            coins -= 1;
        }
    }

    private void showRoundResult() {
        for (RacingCar racingCar : racingCarManager.getRacingCarList()) {
            OutputView.middleResultMessage(racingCar.getCarName(), racingCar.getLocation());
        }

    }

    private void showWinner() {
        WinnerFinder winnerFinder = new WinnerFinder(racingCarManager);
        String winner = winnerFinder.getWinner();
        OutputView.printWinner(winner);
    }

}

