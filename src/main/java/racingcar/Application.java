package racingcar;

import racingcar.domain.Race;
import racingcar.view.InputHandler;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(new InputHandler());
        OutputView outputView = new OutputView();
        Race race = new Race(inputView, outputView);
        race.start();
    }
}
