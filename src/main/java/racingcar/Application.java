package racingcar;


import racingcar.view.input.InputView;
import racingcar.view.input.dto.RacingRequest;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingRequest racingRequest = InputView.promptRacingRequest();
    }
}
