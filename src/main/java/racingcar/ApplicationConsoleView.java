package racingcar;

import static racingcar.ConsoleMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class ApplicationConsoleView implements ApplicationView {

    @Override
    public String requestInputCars() {
        println(REQUEST_INPUT_RACING_CARS);
        return Console.readLine();
    }

    private void println(String message) {
        System.out.println(message);
    }
}
