package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingInputView view = new RacingInputView();
        RacingOutputView outputView = new RacingOutputView();
        RacingController controller = new RacingController(view, outputView);

        controller.RacingRun();
    }
}
