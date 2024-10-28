package racingcar.model;

public class CarName {

    private String name;

    public CarName(String name) {
        validateCarNameLength(name);
        this.name = name.strip();
    }

    public String getName() {
        return name;
    }

    public void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다. 초과된 자동차 이름: " + name);
        }
    }
}
