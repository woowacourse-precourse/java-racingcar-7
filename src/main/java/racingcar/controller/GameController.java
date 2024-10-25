package racingcar.controller;

import java.util.List;
import java.util.HashMap;
import racingcar.model.GamePlayModel;
import racingcar.model.SettingModel;
import racingcar.view.OutputView;

public class GameController {

    public static void gamePlay(List<String> names, int attempt) {
        HashMap<String, Integer> gameRecord = SettingModel.gameSetting(names);
        OutputView.outputResult();
        while (attempt > 0) {
            gameRecord = GamePlayModel.recordAttempt(gameRecord);
            OutputView.outputMoving(gameRecord);
            attempt -= 1;
        }
    }

}
