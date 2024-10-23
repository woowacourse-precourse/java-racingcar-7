package racingcar.factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NamingProcessor {

    private static final String NAME_DELIMITER = ",";

    public NamingProcessor() {
    }

    public List<String> separateName(String namingInput) {
        if (isInvalid(namingInput)) {
            throw new IllegalArgumentException("경주 자동차 이름이 존재하지 않습니다.");
        }

        return Arrays.stream(namingInput.split(NAME_DELIMITER))
                .map(String::trim)
                .toList();
    }

    private boolean isInvalid(String namingInput) {
        return namingInput == null || namingInput.trim().isEmpty();
    }

    public void checkDuplication(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() < names.size()) {
            throw new IllegalArgumentException("경주 자동차 이름은 중복으로 지정할 수 없습니다.");
        }
    }

}
