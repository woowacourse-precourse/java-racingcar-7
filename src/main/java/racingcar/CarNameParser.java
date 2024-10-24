package racingcar;

import static racingcar.ErrorMessage.WRONG_CAR_NAME;

import java.util.StringTokenizer;

public class CarNameParser {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String DELIMITER = ",";

    private final StringTokenizer tokens;

    public CarNameParser(String names) {
        this.tokens = new StringTokenizer(names, DELIMITER);
    }

    public boolean hasMoreName() {
        return tokens.hasMoreTokens();
    }

    public String nextName() {
        String name = tokens.nextToken();

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(WRONG_CAR_NAME.getMessage());
        }
        return name;
    }
}
