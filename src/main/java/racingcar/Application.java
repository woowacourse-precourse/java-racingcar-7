package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputReceiver inputReceiver = new InputReceiver(new InputParser());
        ResultLogger resultLogger = new ResultLogger();
        RacingGame racingGame = new RacingGame(inputReceiver, resultLogger);
        racingGame.run();
    }
}
