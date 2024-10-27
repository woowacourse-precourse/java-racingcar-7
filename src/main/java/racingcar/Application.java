package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RaceService raceService = new RaceService();
        RaceView raceView = new RaceView();
        RaceController controller = new RaceController();

        RaceController controller = new RaceController(raceService, raceView);
        controller.startGame();





    }
}
