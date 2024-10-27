package racingcar.service;

import racingcar.controller.GameController;
import racingcar.model.Game;
import racingcar.valid.NameValid;

import java.util.Arrays;
import java.util.List;

public class SplitService {
    private static SplitService instance;

    private SplitService() {
    }

    public static SplitService getInstance() {
        if (instance == null) {
            instance = new SplitService();
        }
        return instance;
    }

    public List<String> splitNames(String names){
        NameValid.checkNamesInput(names);
        List<String> splitName = Arrays.stream(names.split(","))
                .peek(NameValid::checkName)
                .toList();
        NameValid.checkNameDuplication(splitName);
        NameValid.checkNameCount(splitName.size());
        return splitName;
    }

}
