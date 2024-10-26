package racingcar.controller;

import racingcar.io.Output;
import racingcar.util.Racing;

import java.util.ArrayList;

import static racingcar.io.Input.inputCarName;
import static racingcar.io.Input.inputTryNumber;
import static racingcar.util.Racing.IS_INITIAL;
import static racingcar.util.Racing.racing;

public class Controller {


    public static void run() {
        ArrayList<String> str = inputCarName();
        int temp = inputTryNumber();

        Racing.racing(str, temp);
        Output.printWinner();



    }

}
