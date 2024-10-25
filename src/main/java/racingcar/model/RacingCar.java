package racingcar.model;

public class RacingCar {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int MOVING_THRESHOLD = 4;

    private final String name;
    private int position;

    public RacingCar(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public void attemptMove(int movementFactor) {
        if (movementFactor >= MOVING_THRESHOLD) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public RacingCarSnapShot getSnapshot() {
        return new RacingCarSnapShot(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (containsWhitespace(name)) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
        if (isOverMaxLength(name)) {
            throw new IllegalArgumentException(String.format("자동차 이름의 길이는 %d이하여야 합니다.", NAME_MAX_LENGTH));
        }
    }

    private boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private boolean containsWhitespace(String name) {
        return name.contains(" ");
    }

    private boolean isOverMaxLength(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }
}
