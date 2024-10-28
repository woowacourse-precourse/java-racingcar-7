package racingcar;

import racingcar.domain.Race;
import racingcar.view.InputHandler;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView(new InputHandler());
        final OutputView outputView = new OutputView();
        final Race race = new Race(inputView, outputView);

        race.start();
    }
}
