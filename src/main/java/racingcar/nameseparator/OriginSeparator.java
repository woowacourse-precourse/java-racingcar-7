package racingcar.nameseparator;

import java.util.Arrays;
import java.util.List;
import racingcar.NameSeparator;

public class OriginSeparator implements NameSeparator {

    @Override
    public List<String> separatingNames(String origin) {
        return Arrays.stream(origin.split(",")).toList();
    }
}
