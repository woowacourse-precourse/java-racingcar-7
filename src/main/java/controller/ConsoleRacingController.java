package controller;

import constants.AppConstants;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import utility.CarNameParser;
import view.RacingView;

public class ConsoleRacingController implements RacingController {
    public final RacingView racingView;
    @Override
    public void run() {
        String carNamesAsString = getCarNamesAsString();
        List<String> carNames = CarNameParser.parseCarNames(carNamesAsString);
    }

    @Override
    public String getCarNamesAsString() {
        racingView.showRequestMessage(AppConstants.REQUEST_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }
}
