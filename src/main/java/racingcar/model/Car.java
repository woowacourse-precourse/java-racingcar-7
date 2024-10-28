package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int progress = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어 있으면 안됩니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
    
    public void move() { //이동 조건 필요
        progress++;
    }
}
