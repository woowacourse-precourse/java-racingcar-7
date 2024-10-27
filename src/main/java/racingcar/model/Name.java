package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Name {
    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름을 입력 하셔야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public static List<Name> createNames(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        List<String> nameList = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        Set<String> uniqueNames = new HashSet<>(nameList);
        if (uniqueNames.size() < nameList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

        return nameList.stream()
                .map(Name::new)
                .collect(Collectors.toList());

    }
}
