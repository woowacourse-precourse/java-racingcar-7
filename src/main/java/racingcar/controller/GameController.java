package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.service.GameService;
import racingcar.view.InputView;

public class GameController {
    private Validator validator = new Validator();
    private GameService gameService = new GameService();

    public List<String> getCarNames(){
        InputView.carNamesMessage();
        String carNames = Console.readLine();
        return validator.validateCarName(carNames);
    }

    public int getGameCount(){
        InputView.gameCountMessage();
        String gameCountString = Console.readLine();
        int gameCount = Integer.parseInt(gameCountString);
        return validator.validateGameCount(gameCount);
    }
}
