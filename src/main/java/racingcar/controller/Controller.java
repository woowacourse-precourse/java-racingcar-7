package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.validation.ValidateNames;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;

    public Controller() {
        this.inputView = new InputView();
    }

    public void run() {
        String carNames = inputView.inputCarName();
        List<String> names = getCarNames(carNames);
        for(String name : names) {
            System.out.println(name);
        }
    }

    public static List<String> getCarNames(String inputCarName) {
        ValidateNames.isUnderOne(inputCarName);
        List<String> names = separateNames(inputCarName);
        return names;
    }

    public static List<String> separateNames(String inputCarName) {
        List<String> names = Arrays.asList(inputCarName.split(","));
        ValidateNames.isEmptyName(names, inputCarName);
        ValidateNames.isOverRangeName(names);
        ValidateNames.isDuplicateName(names);
        return names;
    }
}
