package racingcar.nameseparator;

import java.util.Arrays;
import java.util.List;
import racingcar.application.NameSeparator;

public class OriginSeparator implements NameSeparator {

    @Override
    public List<String> separateNames(String origin) {
        if (origin.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해 주세요.");
        }
        return Arrays.stream(origin.split(",")).toList();
    }
}
