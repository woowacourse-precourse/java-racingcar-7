package constant;

public enum GameSettings {
    MOVE_THRESHOLD(4),
    RANDOM_LOWER_BOUND(0),
    RANDOM_UPPER_BOUND(9),
    NAME_MAX(5);

    GameSettings(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }

    private final int message;


}
