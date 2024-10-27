package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.GameController;
import racingcar.controller.UserController;
import racingcar.user.UserObject;

public class InputView {
    public static int trynum;
    public static String result;
    public UserObject[] user;

    public InputView() {
        result = getUserInput();
        trynum = getTryCount();
        user = new UserController(result).settingUser();
        new GameController(user).runGame();
    }

    private String getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().trim();
    }

    private int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
