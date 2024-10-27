package racingcar;

public class Car {
    private final String name;
    private int distance;
    private static final int CRITERIA = 4;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    public void moveOrStop(int number) {
        if (isMovable(number)) {
            this.distance++;
        }
    }

    private boolean isMovable(int number) {
        return number >= CRITERIA;
    }

    private void validateName(String name) {
        checkLength(name);
        checkBlank(name);
        checkAlpha(name);
    }

    private void checkAlpha(String name) {
        String regex = "^[a-zA-Z]+$";
        if (!name.matches(regex)) {
            throw new IllegalArgumentException("이름은 영어(알파벳)로만 생성할 수 있습니다.");
        }
    }

    private void checkBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("공백은 이름이 될 수 없습니다.");
        }
    }

    private void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자보다 클 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
