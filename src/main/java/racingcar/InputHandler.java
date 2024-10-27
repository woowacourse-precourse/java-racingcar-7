package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputHandler {
    private static ArrayList<String> carNameList;

    static ArrayList<String> handleCarNames(InputView inputView){
        carNameList = Arrays.stream(inputView.inputCarName().split(","))
                .collect(Collectors.toCollection(ArrayList::new));
        return carNameList;
    }

    public static ArrayList<String> getCarNameList() {
        return carNameList;
    }
}
