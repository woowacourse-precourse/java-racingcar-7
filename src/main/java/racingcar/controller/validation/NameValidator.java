package racingcar.controller.validation;

import racingcar.view.messages.ErrorMessageEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValidator implements InputValidator<List<String>> {
    @Override
    public void validate(List<String> names) {
        checkEmpty(names.get(0));
        checkDuplicate(names);
    }

    // TODO: try - cathch로 수정?
    private void checkEmpty(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            // TODO: 에러메시지 이넘 get 호출?
            throw new IllegalArgumentException(ErrorMessageEnum.EMPTY_ERROR.getErrorMessage());
        }
    }

    private void checkDuplicate(List<String> names) throws IllegalArgumentException {
        Set<String> singleNames = new HashSet<>(names); // TODO: HashSet??
        if (singleNames.size() != names.size()) {
            // TODO: 에러메시지 이넘 get 호출?
            throw new IllegalArgumentException(ErrorMessageEnum.DUPLICATE_NAMES_ERROR.getErrorMessage());
        }
    }
}
