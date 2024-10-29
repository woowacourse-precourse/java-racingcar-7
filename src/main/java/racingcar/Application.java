package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(Console::readLine);
        OutputView outputView = new OutputView();
        Cars racers = new Cars(inputView.getCarNames());
        Game game = Game.fromInputAndCars(inputView.getTryCounts(), racers);

        game.play(outputView::printRoundResult);
        game.printWinner(outputView::printWinner);
    }
}
