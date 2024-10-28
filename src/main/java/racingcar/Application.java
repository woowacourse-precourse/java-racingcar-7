package racingcar;

public class Application {

    static Race gameStarter = new Race();

    public static void main(String[] args) {
        gameStarter.startRace();
        gameStarter.runRace();
        gameStarter.finishRace();
    }
}
