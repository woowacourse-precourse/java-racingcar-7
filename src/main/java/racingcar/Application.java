package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNameParser carNameParser = new CarNameParser();
        AttemptCountParser attemptCountParser = new AttemptCountParser();
        RandomGenerator randomGenerator = new RandomNumberGenerator();

        RacingGame racingGame = new RacingGame(carNameParser, attemptCountParser, randomGenerator);
        RacingGameController racingGameController = new RacingGameController(racingGame);

        // 경주 시작
        racingGameController.start();
    }
}
