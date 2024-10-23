package racingcar.controller;

import racingcar.domain.Player;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;

import java.util.List;

public class Controller {

    private final InputView input;

    public Controller() {
        input = new InputView();
    }

    public void run() {
        String players = input.readPlayers();
        RacingCar racingCar = new RacingCar(players);
        int count = input.readCount();
        racing(racingCar, count);
    }

    private void racing(RacingCar racingCar ,int count) {
        for (int i = 0; i < count; i++) {
            List<Player> playerList = racingCar.racing();
        }
    }
}
