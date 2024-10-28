package racingcar.domain.race.constants;

public enum RaceFormat {
    RACE_RESULT("실행 결과\n%s"),
    FINAL_WINNER("최종 우승자 : %s");

    private final String format;

    RaceFormat(String format) {
        this.format = format;
    }

    public String generate(Object... objects) {
        return String.format(format, objects);
    }
}
