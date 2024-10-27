package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputReceiver inputReceiver = new InputReceiver(new InputParser());
        RacingGame racingGame = new RacingGame(inputReceiver);
        racingGame.run();
    }
}
