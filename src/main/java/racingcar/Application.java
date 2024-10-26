package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGameController;
import racingcar.util.NameParser;
import racingcar.util.RandomDigitGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        NameParser nameParser = new NameParser();
        OutputView outputView = new OutputView();
        String carName = inputView.carName();
        List<String> carNames = nameParser.carNameParse(carName);
        int tryCount = inputView.tryCount();
        RandomDigitGenerator randomDigitGenerator = new RandomDigitGenerator();

        RacingGameController controller = new RacingGameController(carNames, tryCount, randomDigitGenerator);
        controller.playGame();
        List<String> winner = controller.getWinner();
        outputView.printWinners(winner);
    }
}
