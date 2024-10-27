package racingcar;

import gameManager.Display;
import gameManager.GameManager;
import gameManager.ScoreManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //GameManager gm = new GameManager();
        //Display display = new Display();
        //ScoreManager sm = new ScoreManager();
        Racingcar r = new Racingcar();

        r.start();
        r.setNames();
        r.requestRound();
        r.setRound();
        r.resultMsg();
        r.winnerMsg();

    }
}
