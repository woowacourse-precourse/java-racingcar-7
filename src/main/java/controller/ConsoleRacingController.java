package controller;

import constants.AppConstants;
import camp.nextstep.edu.missionutils.Console;
import view.RacingView;

public class ConsoleRacingController implements RacingController {
    public final RacingView racingView;
    @Override
    public void run() {
        String carNamesAsString = getCarNamesAsString();
    }

    @Override
    public String getCarNamesAsString() {
        racingView.showRequestMessage(AppConstants.REQUEST_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }
}
