package constant;

public enum GameConstants {
    NAME_SEPARATOR (","),
    NAME_VALUE_FORMAT ("%s : %s"),
    WINNER_SEPARATOR (","),
    POSITION_SYMBOL ("-");

    GameConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private final String message;
}
