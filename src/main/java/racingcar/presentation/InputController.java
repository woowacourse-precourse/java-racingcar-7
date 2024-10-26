package racingcar.presentation;

import camp.nextstep.edu.missionutils.Console;

public class InputController {

    public static String getCarNamesInput(){
        OutputController.printCarNamePromptMessage();
        return Console.readLine();
    }
}
