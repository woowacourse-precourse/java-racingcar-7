package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingCarView view = new RacingCarView();
        RacingCarModel model = new RacingCarModel();
        RacingCarController controller = new RacingCarController(model, view);

        controller.initGame();
    }
}
