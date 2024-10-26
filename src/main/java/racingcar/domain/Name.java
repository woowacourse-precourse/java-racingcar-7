package racingcar.domain;

public class Name {

    private final String name;

    private Name(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static Name from(final String name) {
        return new Name(name);
    }
}
