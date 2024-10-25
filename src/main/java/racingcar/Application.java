package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.UserRequestController;

import static racingcar.view.UserResponseView.INPUT_CARS_NAME_MESSAGE;
import static racingcar.view.UserResponseView.INPUT_NUMBER_MESSAGE;

public class Application {
    public static void main(String[] args) {
        UserRequestController userRequestController = new UserRequestController();

        // TODO: 프로그램 구현
        INPUT_CARS_NAME_MESSAGE();
        String carNames = Console.readLine();
        INPUT_NUMBER_MESSAGE();
        String repeatNum = Console.readLine();
        userRequestController.userInputData(carNames, repeatNum);
    }
}
