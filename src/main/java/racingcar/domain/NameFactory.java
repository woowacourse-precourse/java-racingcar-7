package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class NameFactory {

    public static List<Name> createNames(List<String> names) {
        return names.stream()
                .map(Name::from)
                .collect(Collectors.toList());
    }
}
