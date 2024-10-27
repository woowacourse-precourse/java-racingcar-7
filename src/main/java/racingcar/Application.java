package racingcar;

import racingcar.domain.io.RacingInputView;
import racingcar.domain.io.RacingOutputView;
import racingcar.domain.racing.Racing;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingInputView racingInputView = new RacingInputView(new RacingOutputView());
        RacingOutputView racingOutputView = new RacingOutputView();
        Racing racing = new Racing();

        racing.setRacingCars(racingInputView.readRacingCarNames());
        racing.setTryCount(racingInputView.readTryCount());

        racing.iterateRace();
        racing.calculateWinner();
        racingOutputView.printRacingResult(racing.getWinnerNames());
    }
}
