package racingcar.core.view;

import racingcar.domain.RacingCar;
import racingcar.message.Message;
import racingcar.message.RacingMessage;

import java.util.LinkedHashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.message.RacingMessage.*;
import static racingcar.message.utils.CarPositionMessageUtils.generateCarsPositionMessage;
import static racingcar.message.utils.FinalWinnersMessageUtils.generateFinalWinnersMessage;

public class RacingView {

    public String inputCars() {
        return inputUserWithMessage(INPUT_CAR_NAMES);
    }

    public String inputTryCount() {
        return inputUserWithMessage(INPUT_TRY_COUNT);
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

    private String inputUserWithMessage(RacingMessage message) {
        printMessage(message);
        return readLine();
    }

    private void printMessage(Message message) {
        printMessage(message.getMessage());
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
