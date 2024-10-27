package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        validateNameDuplicate(names);
        this.names = new ArrayList<>(names);
    }

    private void validateNameDuplicate(List<Name> names) {
        Set<Name> duplicateNames = new HashSet<>(names);
        if (duplicateNames.size() != names.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public int size() {
        return names.size();
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
