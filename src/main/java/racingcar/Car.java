package racingcar;

// 자동차의 이름
public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자일 수 없다");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이여야 함");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
