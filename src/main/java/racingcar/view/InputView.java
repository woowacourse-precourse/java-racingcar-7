package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;
import racingcar.controller.UserController;
import racingcar.user.UserObject;
import racingcar.validator.Validator;

public class InputView {
    public static int tryNumber;
    private String userInput;
    private UserObject[] user;

    public InputView() {
        userInput = getUserInput();
        tryNumber = getTryCount();
        Validator.isValidateNumber();
        user = new UserController(userInput).initializeUsers();
        new GameController().runGame(user);
    }

    private String getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().trim();
    }

    private int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
