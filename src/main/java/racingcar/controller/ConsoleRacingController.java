package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constants.AppConstants;
import racingcar.service.CarService;
import racingcar.utility.CarNameParser;
import racingcar.view.RacingView;

public class ConsoleRacingController implements RacingController {
    public final RacingView racingView;
    public final CarService carService;

    public ConsoleRacingController(RacingView racingView, CarService carService) {
        this.racingView = racingView;
        this.carService = carService;
    }

    @Override
    public void run() {
        String carNamesAsString = getCarNamesAsString();
        List<String> carNames = CarNameParser.parseCarNames(carNamesAsString);
        carNames.forEach(carService::register);
        int moveCount = getMoveCount();
    }

    @Override
    public String getCarNamesAsString() {
        racingView.showRequestMessage(AppConstants.REQUEST_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    @Override
    public int getMoveCount() {
        racingView.showRequestMessage(AppConstants.REQUEST_MOVE_COUNT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("아무 숫자도 입력하지 않음");
        }
    }
}
