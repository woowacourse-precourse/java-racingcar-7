package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.validation.NamesValidation;

public class NameController {

    public static List<String> getCarNames(String inputCarName) {
        NamesValidation.isUnderOne(inputCarName);
        List<String> names = separateNames(inputCarName);
        return names;
    }

    public static List<String> separateNames(String inputCarName) {
        List<String> names = Arrays.asList(inputCarName.split(","));
        NamesValidation.isEmptyName(names, inputCarName);
        NamesValidation.isOverRangeName(names);
        NamesValidation.isDuplicateName(names);
        return names;
    }

}


