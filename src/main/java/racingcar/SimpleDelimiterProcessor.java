package racingcar;


public class SimpleDelimiterProcessor implements Processor{
    private static final String NULL_INPUT = "입력이 null입니다.";
    private static final String INVALID_INPUT = "입력이 유효하지 않습니다.";
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public String[] process(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT);
        }
        String[] names = input.replace(" ", "").split(NAME_DELIMITER);
        isInvalidInput(names);
        return names;
    }

    private void isInvalidInput(String[] names) {
        for (String name: names) {
            if (isInvalidName(name)) {
                throw new IllegalArgumentException(INVALID_INPUT);
            }
        }
    }

    private boolean isInvalidName(String name) {
        return name.length() >= MAX_NAME_LENGTH;
    }
}
