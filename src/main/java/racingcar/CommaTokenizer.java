package racingcar;

public class CommaTokenizer {
    private static final String COMMA = ",";

    public String[] split(String input) {
        return input.split(COMMA);
    }
}
