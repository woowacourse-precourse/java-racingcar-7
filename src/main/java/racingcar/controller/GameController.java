package racingcar.controller;

import java.util.List;
import java.util.HashMap;
import racingcar.model.GamePlayModel;
import racingcar.model.SettingModel;
import racingcar.view.OutputPlayView;

public class GameController {

    public static HashMap<String, Integer> gamePlay(List<String> names, int attempt) {
        HashMap<String, Integer> gameRecord = SettingModel.gameSetting(names);
        OutputPlayView.outputResult();
        while (attempt > 0) {
            gameRecord = GamePlayModel.recordAttempt(gameRecord);
            OutputPlayView.outputMoving(gameRecord);
            attempt -= 1;
        }
        return gameRecord;
    }

}
