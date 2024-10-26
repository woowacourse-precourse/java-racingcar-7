package racingcar.model;


public class Car {

    private static final int DEFAULT_POSITION_VALUE = 0;
    private static final int MOVABLE_NUMBER_OF_CRITERIA = 4;
    private static final int MOVE_DISTANCE = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NOTATION_OF_POSITION = "-";

    private final String name;
    private int position;

    private Car(final String name) {
        checkNameLength(name);
        this.name = name;
        this.position = DEFAULT_POSITION_VALUE;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    private void checkNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 %s자 이하여야 합니다.".formatted(MAX_NAME_LENGTH));
        }
    }

    public void move(final int number) {
        if (number >= MOVABLE_NUMBER_OF_CRITERIA) {
            position += MOVE_DISTANCE;
        }
    }

    public boolean isNotSamePositionTo(final int position) {
        return this.position != position;
    }

    public String getCurrentSituation() {
        return String.format("%s : %s", name, NOTATION_OF_POSITION.repeat(position));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
