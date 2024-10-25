package racingcar;

import java.util.HashMap;
import java.util.List;

public class Controller {
    View view = new View();
    Model model = new Model();

    public void run() {
        String[] listUser = view.getUserinfo();
        String round = view.getRoundinfo();
        HashMap<String, String> initRacingHashmap = model.initRacing(listUser);
        HashMap<String, String> RacingHashmap = model.Racing(initRacingHashmap, round);
        List listWinners = model.findWinner(RacingHashmap);
        view.displayResult(listWinners);
    }
}