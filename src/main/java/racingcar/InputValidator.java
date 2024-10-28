package racingcar;

import racingcar.controller.InputHandler;

public class InputValidator {

    public static void notOneName(InputHandler inputHandler){
        if(inputHandler.getCarNameList().size() <= 1){
            throw new IllegalArgumentException();
        }
    }
}
