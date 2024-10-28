package racingcar.view;

import static racingcar.common.ConsoleMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class ApplicationConsoleView implements ApplicationView {

    @Override
    public String requestInputCars() {
        println(REQUEST_INPUT_RACING_CARS);
        return Console.readLine();
    }

    @Override
    public int requestGameCount() {
        println(REQUEST_INPUT_GAME_COUNT);
        return Integer.parseInt(Console.readLine());
    }

    private void println(String message) {
        System.out.println(message);
    }
}
