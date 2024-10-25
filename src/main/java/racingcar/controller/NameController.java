package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.validation.ValidateNames;

public class NameController {

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
