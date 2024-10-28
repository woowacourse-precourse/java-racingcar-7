package racingcar;

public class Application {
    static RaceManager gameManager = new RaceManager();

    public static void main(String[] args) {
        gameManager.startRace();
        gameManager.runRace();
        gameManager.finishRace();
    }
}
