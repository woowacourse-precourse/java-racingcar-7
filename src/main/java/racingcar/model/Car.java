package racingcar.model;

public class Car {

    private final String name;
    private int advanceCount = 0;

    private Car(String name) {
        validateCarNameLength(name);
        this.name = name.strip();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void advance(int number) {
        if (number > 3) {
            advanceCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다. 초과된 자동차 이름: " + name);
        }
    }
}
