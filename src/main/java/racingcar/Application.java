package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RaceService raceService = new RaceService();
        RaceView raceView = new RaceView();
        InputValidator inputValidator = new InputValidator();
        RaceController controller = new RaceController(raceService, raceView, inputValidator);

        controller.startGame();

    }
}
