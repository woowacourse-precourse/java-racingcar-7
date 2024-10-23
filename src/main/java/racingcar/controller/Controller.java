package racingcar.controller;

import racingcar.domain.Player;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    private final InputView input;
    private final OutputView output;

    public Controller() {
        input = new InputView();
        output = new OutputView();
    }

    public void run() {
        String players = input.readPlayers();
        RacingCar racingCar = new RacingCar(players);
        int count = input.readCount();
        racing(racingCar, count);
    }

    private void racing(RacingCar racingCar ,int count) {
        output.printExecutionResult();
        for (int i = 0; i < count; i++) {
            List<Player> playerList = racingCar.racing();
            for (Player player : playerList) {
                output.printRacingResult(player.getName(), player.getScore());
            }
        }
        output.printWinner(racingCar.createWinner());
    }
}
