package racingcar.model;

public class RaceCar {
    private static final String ERROR_CAR_NAME_RANGE = "자동차 이름은 1~5자까지 허용합니다.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;
    private static final int INIT_POSITION = 0;

    private final String name;
    private int position;

    private RaceCar(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static RaceCar fromName(String name) {
        String trimmedName = trimAndValidateName(name);
        return new RaceCar(trimmedName, INIT_POSITION);
    }

    private static String trimAndValidateName(String name) {
        String trimmedName = name.trim();
        validateNameRange(trimmedName);
        return trimmedName;
    }

    private static void validateNameRange(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_RANGE);
        }
    }

    public void move() {
        position++;
    }

    public boolean isWinner(int winPosition) {
        return this.position == winPosition;
    }

    public boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
