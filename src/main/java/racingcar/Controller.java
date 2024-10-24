package racingcar;

import java.util.List;

public class Controller {
    View view = new View();
    Model model = new Model();

    public void run() {
        String[] listUser = view.getUserinfo();
        int round = view.getRoundinfo();
        List<String> listWinners = model.makeRacingHashmap(listUser, round);
        view.displayResult(listWinners);
    }
}