package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Car;
import racingcar.enums.ErrorMessage;
import racingcar.enums.ViewMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        String inputString = inputView.promptCarNames();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        List<Car> cars = new ArrayList<>();
        List<String> winners = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.getMessage());
            }
            cars.add(new Car(carName));
        }
        int rounds = Integer.parseInt(inputView.promptRounds());
        outputView.printResult();
        int maxMoveCount = 0;
        while (rounds-- > 0) {
            for (Car car : cars) {
                int value = Randoms.pickNumberInRange(0, 9);
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
        for (Car car : cars) {
            if (car.moveCount == maxMoveCount) {
                winners.add(car.name);
            }
        }
        String result = String.join(", ", winners);
        outputView.printWinners(result);
    }
}
