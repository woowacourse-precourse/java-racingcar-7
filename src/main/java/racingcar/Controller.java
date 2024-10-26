package racingcar;

import java.util.HashMap;
import java.util.List;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Model model = new Model();

    public void run() {
        String[] listUser = inputView.getUserinfo();
        String round = inputView.getRoundinfo();
        HashMap<String, String> initRacingHashmap = model.initRacing(listUser);
        HashMap<String, String> RacingHashmap = model.Racing(initRacingHashmap, round);
        List listWinners = model.findWinner(RacingHashmap);
        outputView.displayResult(listWinners);
    }
}