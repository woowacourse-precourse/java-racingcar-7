package racingcar;

import racingcar.car.CarInputService;
import racingcar.car.CarInputValidator;
import racingcar.count.CountInputService;
import racingcar.count.CountInputValidator;
import racingcar.game.Game;
import racingcar.game.GameView;
import racingcar.game.RankService;

public class Application {
    public static void main(String[] args) {
        CarInputValidator carInputValidator = new CarInputValidator();
        CarInputService carInputService = new CarInputService(carInputValidator);

        CountInputValidator countInputValidator = new CountInputValidator();
        CountInputService countInputService = new CountInputService(countInputValidator);

        RankService rankService = new RankService();
        GameView gameView = new GameView(rankService);

        Game game = new Game(carInputService, countInputService, gameView);

        game.run();
    }
}
