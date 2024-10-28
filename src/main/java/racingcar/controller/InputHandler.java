package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.view.InputView;

public class InputHandler {
    private static ArrayList<String> carNameList = new ArrayList<>();

    public static ArrayList<String> handleCarNames(InputView inputView){
        carNameList = Arrays.stream(inputView.inputCarName().split(","))
                .collect(Collectors.toCollection(ArrayList::new));
        return carNameList;
    }

    public static ArrayList<String> getCarNameList() {
        for (int i = 0; i < carNameList.size(); i++) {
            carNameList.set(i, carNameList.get(i).replaceAll("^\\s+|\\s+$", ""));
        }
        return carNameList;
    }
}
