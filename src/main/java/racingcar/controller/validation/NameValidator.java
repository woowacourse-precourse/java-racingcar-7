package racingcar.controller.validation;

import racingcar.view.messages.ErrorMessageEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValidator implements InputValidator<List<String>> {
    @Override
    public int validate(List<String> names) {
        checkEmpty(names.get(0));
        checkLength(names);
        checkDuplicate(names);
        return 1; // TODO: 크아아아악 ㅜㅜㅜ
    }

    private void checkLength(List<String> names) throws IllegalArgumentException {
        for (String name : names) { // TODO: 스트림으로 고칠 수 있나?
            if (name.length() > 5) {
                throw new IllegalArgumentException(ErrorMessageEnum.NAME_LENGTH_ERROR.getErrorMessage());
            }
        }
    }

    // TODO: try-catch로 수정?
    private void checkDuplicate(List<String> names) throws IllegalArgumentException {
        Set<String> singleNames = new HashSet<>(names); // TODO: HashSet??
        if (singleNames.size() != names.size()) {
            // TODO: 에러메시지 이넘 get 호출?
            throw new IllegalArgumentException(ErrorMessageEnum.DUPLICATE_NAMES_ERROR.getErrorMessage());
        }
    }
}
