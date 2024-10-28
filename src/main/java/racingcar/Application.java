package racingcar;

public class Application {
    public static void main(String[] args) {
        RaceView view = new RaceView();
        RaceController controller = new RaceController(view);
        controller.startGame();
    }
}
