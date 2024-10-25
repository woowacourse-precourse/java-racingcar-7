package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.model.WinnerModel;
import racingcar.view.OutputResultView;

public class ResultController {

    public static void resultGame(HashMap<String, Integer> gameRecord) {
        List<String> winners = WinnerModel.gameWinner(gameRecord);
        OutputResultView.outputResult(winners);
    }

}
