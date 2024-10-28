package racingcar;

public class Car {
    private static final int MOVE_OKAY = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_OKAY) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 빈 값일 순 없음.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능.");
        }
    }
}
