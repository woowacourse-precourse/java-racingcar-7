package racingcar.domain;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static void validateName(String name) {
        if(name.length()>5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야합니다.");
        if(name.isBlank()) throw new IllegalArgumentException("자동차 이름은 공백이면 안됩니다.");
    }
}
