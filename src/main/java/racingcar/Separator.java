package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Separator {
    private static final String TOKEN = ",";

    public List<String> separate(String inputNames) {
        return Arrays.stream(inputNames.split(TOKEN))
                .map(name -> checkNameLength(name.trim()))
                .collect(Collectors.toList());
    }

    private String checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 넘길 수 없습니다");
        }

        return name;
    }
}
