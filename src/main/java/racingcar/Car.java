package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateEmpty(name);
        validateName(name);
        validateLength(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if (value >= 4) {
            this.position++;
        }
    }

    public String displayStatus() {
        return name.trim() + " : " + "-".repeat(position);
    }

    private void validateEmpty(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }

    private void validateName(String name) {
        if (!name.matches("[a-zA-Z0-9가-힣 ]+")) {
            throw new IllegalArgumentException("이름은 문자나 숫자만 가능합니다.");
        }
    }

    private void validateLength(String name) {
        if (!(name.length() <= 5)) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }
}