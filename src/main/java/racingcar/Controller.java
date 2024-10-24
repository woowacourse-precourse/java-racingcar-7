package racingcar;

import java.util.HashMap;
import java.util.List;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run(){
        String[] listUser = view.getUserinfo();
        int round = view.getRoundinfo();
        HashMap<String, String> userInfo = model.makeRacingHashmap(listUser, round);
        List<String> listWinners = model.findWinner(userInfo);
        view.displayResult(listWinners);
    }
}
