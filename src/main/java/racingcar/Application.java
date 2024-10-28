package racingcar;

public class Application {

    public static void main(String[] args) {
        RacingGameInput input = new RacingGameInput();
        RacingGameOutput output = new RacingGameOutput();
        RacingGameController controller = new RacingGameController(input, output);
        controller.run();
    }
}
