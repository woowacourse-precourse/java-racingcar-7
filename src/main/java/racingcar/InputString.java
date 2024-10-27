package racingcar;

public class InputString {

    private String inputString;
    private final String DELIMITER = ",";
    private final String NULL_ERROR_MESSAGE = "[error] 자동차의 이름이 입력되지 않았습니다.";
    private final String OVERSIZE_NAME_ERROR_MESSAGE = "[error] 자동차의 이름은 최대 5글자입니다.";
    private final int MAX_CAR_NAME_LEN = 5;

    InputString(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
        inputString = string;
    }

    public String getInputString() {
        return inputString;
    }

    public CarCollection getCarCollection() {
        String names[] = inputString.split(DELIMITER);
        checkingValidation(names);
        CarCollection carCollection = new CarCollection();
        for (String name : names) {
            carCollection.add(name);
        }
        return carCollection;
    }

    private void checkingValidation(String[] names) {
        for (String name : names) {
            if (name.length() > MAX_CAR_NAME_LEN) {
                throw new IllegalArgumentException(OVERSIZE_NAME_ERROR_MESSAGE);
            }
        }
    }
}
