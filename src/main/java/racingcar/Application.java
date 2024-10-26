package racingcar;

import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        UI ui = new UI();

        String[] carNames = ui.getCarNames();
        int limit = ui.getRoundLimit();

        RacingGame racingGame = new RacingGame(limit);

        racingGame.setParticipants(carNames);

        racingGame.playGame();
    }
}
