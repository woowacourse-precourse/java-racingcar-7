package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarInputHandler carInputHandler = new CarInputHandler();
        String inputCarNames = carInputHandler.userInputCarNames();
        String[] separatedCarNames = carInputHandler.splitCarNames(inputCarNames);
        List<String> carNameList = new ArrayList<>(Arrays.asList(separatedCarNames));

        int howManyTimesMove = carInputHandler.userInputHowManyTimes();


    }
}
