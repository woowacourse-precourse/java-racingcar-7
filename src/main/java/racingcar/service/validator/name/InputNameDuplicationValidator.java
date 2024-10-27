package racingcar.service.validator.name;

import java.util.ArrayList;
import java.util.List;

public class InputNameDuplicationValidator implements InputNameValidator {

    @Override
    public void validate(String inputNames) {
        List<String> checkedNames = new ArrayList<>();
        for (String name : splitInputNames(inputNames)) {
            checkDuplication(name, checkedNames);
            checkedNames.add(name);
        }
    }

    private void checkDuplication(String name, List<String> checkedNames) {
        if (checkedNames.contains(name)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }
}
