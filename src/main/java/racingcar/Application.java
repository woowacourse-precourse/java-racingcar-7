package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingCarAppConfig config = new RacingCarAppConfig();
        RaceGameService raceGame = config.raceGame();

        raceGame.start();
    }
}