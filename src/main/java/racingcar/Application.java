package racingcar;

import racingcar.car.CarInputService;
import racingcar.car.CarInputValidator;
import racingcar.count.CountInputService;
import racingcar.count.CountInputValidator;
import racingcar.game.Game;
import racingcar.game.GameService;
import racingcar.game.GameView;

public class Application {
    public static void main(String[] args) {
        CarInputValidator carInputValidator = new CarInputValidator();
        CarInputService carInputService = new CarInputService(carInputValidator);

        CountInputValidator countInputValidator = new CountInputValidator();
        CountInputService countInputService = new CountInputService(countInputValidator);

        GameService gameService = new GameService();
        GameView gameView = new GameView(gameService);

        Game game = new Game(carInputService, countInputService, gameService, gameView);

        game.run();
    }
}
