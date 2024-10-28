package racingcar;

import java.util.ArrayList;
import racingcar.controller.InputHandler;

public class InputValidator {

    public static void notOneName(ArrayList<String> carNameList){
        if(InputHandler.getCarNameList().size() <= 1){
            throw new IllegalArgumentException();
        }
    }

    public static void notOverFiveLetter(ArrayList<String> carNameList) {
        for (String carName : carNameList) {
            if(carName.length() >5){
                throw new IllegalArgumentException();
            }
        }
    }
}
