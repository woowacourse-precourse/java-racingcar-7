package racingcar;
import racingcar.domain.GameSettings;
import racingcar.service.RacingGame;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameSettings settings = InputView.getGameSettings();
        RacingGame game = new RacingGame(settings);
        game.start();
    }
}
