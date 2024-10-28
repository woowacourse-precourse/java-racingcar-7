package racingcar.model;

public enum OutputFormat {
    START_RESULT("\n실행 결과\n"),
    TWO_LINE_DEVIDE("\n\n"),
    FINAL_TOP_RANKER("최종 우승자 : "),
    FINAL_TOP_RANKER_DELIMITER(", "),
    POSITION("-"),
    NAME_POSITION_DEVIDE(" : ");


    private final String format;

    OutputFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
