package racingcar;

import java.util.HashMap;
import java.util.List;

public class RacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RacingModel racingModel = new RacingModel();

    public void run() {
        String[] listUser = inputView.getUserinfo();
        String round = inputView.getRoundinfo();
        HashMap<String, String> initRacingHashmap = racingModel.initRacing(listUser);
        HashMap<String, String> RacingHashmap = racingModel.Racing(initRacingHashmap, round);
        List listWinners = racingModel.findWinner(RacingHashmap);
        outputView.displayResult(listWinners);
    }
}