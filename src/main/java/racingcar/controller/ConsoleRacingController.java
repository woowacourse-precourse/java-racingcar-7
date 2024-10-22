package racingcar.controller;

import racingcar.constants.AppConstants;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.service.CarService;
import racingcar.utility.CarNameParser;
import racingcar.view.RacingView;

public class ConsoleRacingController implements RacingController {
    public final RacingView racingView;
    public final CarService carService;
    @Override
    public void run() {
        String carNamesAsString = getCarNamesAsString();
        List<String> carNames = CarNameParser.parseCarNames(carNamesAsString);
        carNames.forEach(carService::register);
    }

    @Override
    public String getCarNamesAsString() {
        racingView.showRequestMessage(AppConstants.REQUEST_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }
}
