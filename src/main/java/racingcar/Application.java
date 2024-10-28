package racingcar;

public class Application {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Racing racing = new Racing();

        racing.setCarName();
        racing.setRound();
        racing.inGame();
    }
}
