package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.enums.Constants;
import racingcar.enums.Delimiter;
import racingcar.enums.ViewMessage;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void play() {
        String inputString = inputView.promptCarNames();
        List<Car> cars = racingCarService.makeCarList(inputString);
        int rounds = Integer.parseInt(inputView.promptRounds());
        outputView.printResult();
        int maxMoveCount = 0;
        while (rounds-- > 0) {
            for (Car car : cars) {
                int value = Randoms.pickNumberInRange(Constants.RANGE_LOWER_BOUND.getValue(),
                        Constants.RANGE_UPPER_BOUND.getValue());
                car.move(value);
                maxMoveCount = Math.max(maxMoveCount, car.moveCount);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Car car : cars) {
                stringBuilder.append(car);
                stringBuilder.append(ViewMessage.PRINT_BLANK.getMessage());
            }
            outputView.printRoundStatus(stringBuilder.toString());
        }
        List<String> winners = racingCarService.findWinners(cars, maxMoveCount);
        String result = String.join(Delimiter.COMMA_WITH_SPACE.getSymbol(), winners);
        outputView.printWinners(result);
    }
}
