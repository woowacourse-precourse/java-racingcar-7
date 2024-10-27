package racingcar;

import static racingcar.OutputHandler.printMoveCountAndName;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_STANDARD = 4;

    private final String name;
    private int moveCount;

    public Participant(String name) {
        validate(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null 이 될수 없습니다.");
        }

        if (name.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이상으로 작성할수 없습니다.");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될수 없습니다.");
        }
    }

    public void race(int count) {
        if (count >= MOVE_STANDARD) {
            this.moveCount++;
        }
    }

    public void printStatus() {
        printMoveCountAndName(name, moveCount);
    }


    public int getMoveCount() {
        return this.moveCount;
    }

    public String getName() {
        return this.name;
    }
}
