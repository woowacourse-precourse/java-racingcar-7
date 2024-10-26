package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_FORM = "[A-Za-z0-9]+";
    private static final int MOVEMENT_CONDITION = 4;

    private final String name;
    private int moveCount;

    public Car(String name, int moveCount) {
        checkNameLength(name);
        checkNameForm(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    public void move(int number) {
        if (MOVEMENT_CONDITION <= number) {
            ++moveCount;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void checkNameLength(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNameForm(String name) {
        if (!name.matches(NAME_FORM)) {
            throw new IllegalArgumentException();
        }
    }
}
