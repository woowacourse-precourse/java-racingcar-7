package racingcar;

public class Application {

    // TODO: 참가자들 이름 겹치는 케이스 고려하기
    public static void main(String[] args) {
        RacingGameInput input = new RacingGameInput();
        RacingGameOutput output = new RacingGameOutput();
        RacingGameController controller = new RacingGameController(input, output);
        controller.run();
    }
}
