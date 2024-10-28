package racingcar;


public class Application {
    public static void main(String[] args) {
        Racingcar r = new Racingcar();

        r.start();
        r.setNames();
        r.requestRound();
        r.setRound();
        r.resultMsg();
        r.winnerMsg();

    }
}
