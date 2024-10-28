package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position++;
        }
    }

    public String getStatus() {
        return name + " : " + "-".repeat(position);
    }
}
