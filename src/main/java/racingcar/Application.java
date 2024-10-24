package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingInputView view = new RacingInputView();
        RacingOutputView outputView = new RacingOutputView();
        RacingController controller = new RacingController(view, outputView);

        controller.RacingRun();
    }
}
