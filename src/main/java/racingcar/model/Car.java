package racingcar.model;

public class Car {
    private final String name;
    private int advanceCount;

    public Car(String name) {
        validateName(name);

        this.name = name;
        advanceCount = 0;
    }

    public String getName() {
        return name;
    }

    public void advance() {
        advanceCount++;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void stop() { }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
