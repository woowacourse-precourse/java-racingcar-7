package racingcar.service.validator.name;

public class InputNameCountValidator implements InputNameValidator {
    private final static String NAME_SPLIT_DELIMITER = ",";

    @Override
    public void validate(String inputNames) {
        checkInputNames(countInputNames(inputNames));
    }

    private long countInputNames(String inputNames) {
        String[] names = inputNames.split(NAME_SPLIT_DELIMITER);
        return names.length;
    }

    private void checkInputNames(long inputNamesCount) {
        if (isInvalidNameCount(inputNamesCount)) {
            throw new IllegalArgumentException("차의 이름들은 최대 99개까지 가능합니다.");
        }
    }

    private boolean isInvalidNameCount(long inputNamesCount) {
        return inputNamesCount >= 100;
    }
}
