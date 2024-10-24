package racingcar.controller.validation;

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
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<String> names) throws IllegalArgumentException {
        Set<String> singleNames = new HashSet<>(names); // TODO: HashSet??
        if (singleNames.size() != names.size()) {
            throw new IllegalArgumentException();
        }
    }
}
