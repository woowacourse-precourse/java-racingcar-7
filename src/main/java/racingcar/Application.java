package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingInputView view = new RacingInputView();
        RacingController controller = new RacingController(view);

        controller.RacingRun();
    }
}
