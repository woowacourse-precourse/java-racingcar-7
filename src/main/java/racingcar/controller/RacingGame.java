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

        initializeRacingCars();
        int gameCoin = getGameCoin();
        playRounds(gameCoin);
        showWinner();
    }

    private void initializeRacingCars() {
        OutputView.printCarNameInputMessage();
        RacingCarNameInput racingCarNameInput = new RacingCarNameInput(InputView.readLine());
        List<String> nameList = racingCarNameInput.getRacingCarNameList();
        for (String name : nameList) {
            racingCarManager.newCar(new RacingCar(name));
        }
    }

    private int getGameCoin() {
        OutputView.printCoinInsertMessage();
        GameCoinInput gameCoinInput = new GameCoinInput(InputView.readLine());
        return gameCoinInput.getGameCoin();
    }

    private void playRounds(int coins) {
        OutputView.printExecuteResultMessage();

        while (coins > 0) {
            playRound();
            OutputView.printEmptyLine();
            coins -= 1;
        }
    }

    private void playRound() {
        racingCarManager.playRound();
        showRoundResult();
    }

    private void showRoundResult() {
        for (RacingCar racingCar : racingCarManager.getRacingCarList()) {
            OutputView.printRoundResultMessage(racingCar.getCarName(), racingCar.getLocation());
        }
    }

    private void showWinner() {
        String winner = findWinner();
        OutputView.printWinner(winner);
    }

    private String findWinner() {
        WinnerFinder winnerFinder = new WinnerFinder(racingCarManager);
        String winner = winnerFinder.getWinner();
        return winner;
    }

}

