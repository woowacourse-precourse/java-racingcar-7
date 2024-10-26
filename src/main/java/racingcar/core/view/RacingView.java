package racingcar.core.view;

import racingcar.domain.RacingCar;
import racingcar.message.Message;

import java.util.LinkedHashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.message.RacingMessage.*;
import static racingcar.message.utils.CarPositionMessageUtils.generateCarsPositionMessage;
import static racingcar.message.utils.FinalWinnersMessageUtils.generateFinalWinnersMessage;

public class RacingView {

    public String inputCars() {
        printMessage(INPUT_CAR_NAMES);
        return readLine();
    }

    public String inputTryCount() {
        printMessage(INPUT_TRY_COUNT);
        return readLine();
    }

    public void printExcuteResult() {
        printMessage(EXECUTE_RESULT);
    }

    public void printCarsPosition(LinkedHashSet<RacingCar> cars) {
        printMessage(generateCarsPositionMessage(cars));
    }

    public void printFinalWinners(List<RacingCar> winners) {
        printMessage(generateFinalWinnersMessage(winners));
    }

    private void printMessage(Message message) {
        printMessage(message.getMessage());
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
