package racingcar;

public class Application {
    public static void main(String[] args) {
        RaceService raceService = new RaceService();
        GameController gameController = new GameController(raceService);
        gameController.startGame();
    }
}
