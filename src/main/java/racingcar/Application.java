package racingcar;

import racingcar.controller.Controller;

import static racingcar.io.Input.*;
import static racingcar.util.Racing.IS_INITIAL;

public class Application {
    public static void main(String[] args) {

        Controller.run();
        IS_INITIAL = false;

    }
}
