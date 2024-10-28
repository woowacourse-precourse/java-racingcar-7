package racingcar.service.validation;

import racingcar.service.utils.ExceptionUtils;
import racingcar.view.messages.ErrorMessageEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValidator implements InputValidator<List<String>> {
    @Override
    public void validate(List<String> names) {
        checkEmpty(names.get(0));
        checkLength(names);
        checkDuplicate(names);
    }

    private void checkLength(List<String> names) throws IllegalArgumentException {
        for (String name : names) {
            if (name.length() > 5) {
                ExceptionUtils.throwIllegalArgumentException(ErrorMessageEnum.NAME_LENGTH_ERROR);
            }
        }
    }

    private void checkDuplicate(List<String> names) throws IllegalArgumentException {
        Set<String> singleNames = new HashSet<>(names);
        if (singleNames.size() != names.size()) {
            ExceptionUtils.throwIllegalArgumentException(ErrorMessageEnum.DUPLICATE_NAMES_ERROR);
        }
    }
}
