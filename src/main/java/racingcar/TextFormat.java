package racingcar;

public enum TextFormat {
    RACING_TRY_RESULT("%s : "),
    RACING_GAME_WINNER("%s, "),
    RACING_GAME_RESULT("최종 우승자 : %s");

    private final String format;

    TextFormat(String format) {
        this.format = format;
    }

    public String format(Object args) {
        return String.format(this.format, args);
    }
}
