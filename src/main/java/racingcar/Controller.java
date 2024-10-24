package racingcar;

import java.util.List;

public class Controller {
    public static void run(){
        String[] listUser = View.getUserinfo();
        int round = View.getRoundinfo();
        List<String> listWinners = Model.makeRacingHashmap(listUser, round);
        View.displayResult(listWinners);
    }
}