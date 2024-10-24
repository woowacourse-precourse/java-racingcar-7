package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_ERROR_MESSAGE = "이름은 " + NAME_MAX_LENGTH + "글자 이하로 입력해주세요.";
    private List<String> names;

    public Cars(String names) {
        this(isValid(parse(names)));
    }

    public Cars(String[] names) {
        this(isValid(Arrays.asList(names)));
    }

    public Cars(List<String> names) {
        this.names = names;
    }

    private static List<String> parse(String names) {
        return Arrays.asList(names.split(","));
    }

    private static List<String> isValid(List<String> names) {
        names.stream()
                .filter(name -> name.length() > NAME_MAX_LENGTH)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
                });

        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(names, cars.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

}
