package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {

    private final int MAX_SIZE = 1000;

    private final List<Name> names;

    public Names(List<Name> names) {
        validateNameDuplicate(names);
        this.names = new ArrayList<>(names);
    }

    private void validateNameDuplicate(List<Name> names) {
        if (names.size() > MAX_SIZE) {
            throw new IllegalArgumentException("이름의 개수가 " + MAX_SIZE + "개를 넘을 수 없습니다.");
        }
        Set<String> nonDuplicateNames = new HashSet<>();
        for (Name name : names) {
            nonDuplicateNames.add(name.toString());
        }
        if (nonDuplicateNames.size() != names.size()) {
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
