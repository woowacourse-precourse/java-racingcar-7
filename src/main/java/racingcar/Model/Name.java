package racingcar.Model;

public class Name {
    private final String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력되어야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
