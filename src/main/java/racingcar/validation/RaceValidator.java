package racingcar.validation;

public class RaceValidator {
    private final String REGEXP = "^[0-9]+$";
    private final String COMMA = ",";

    public void isNotNullOrEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException(RaceValidatorException.NULL_INPUT.getMessage()); // null 체크
        }
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(RaceValidatorException.NULL_INPUT.getMessage());
        }
    }

    public boolean validateTryCount(String input) {
        int inputInteger = validateTryCountType(input);
        if (inputInteger < 1) {
            throw new IllegalArgumentException(RaceValidatorException.NEGATIVE_TRY_COUNT.getMessage());
        }
        return true;
    }

    public void validateCarName(String input){
        isNotNullOrEmpty(input);
        isStartedWithComma(input);
        validateCommaFormat(input);
    }

    private String removeAllSpaces(String input) {
        return input.replaceAll("\\s+", ""); // 모든 공백 제거
    }


    private void validateCarNameLength(String input){
        if(removeAllSpaces(input).length()>5){
            throw new IllegalArgumentException(RaceValidatorException.INVALID_CAR_NAME.getMessage());
        }
    }

    private void isStartedWithComma(String input){
        if(input.startsWith(COMMA)){
            throw new IllegalArgumentException(RaceValidatorException.STARTED_WITH_COMMA.getMessage());
        }
    }

    private long countCommas(String input) {
        return input.chars()
                .filter(c -> c == ',')
                .count();
    }

    private void validateCommaFormat(String input){
        String[] carNames = input.split(COMMA);
        if(countCommas(input)>=carNames.length){
            throw new IllegalArgumentException(RaceValidatorException.INVAILD_CAR_NAMES.getMessage());
        }
         validateCarNamesLength(carNames);
    }

    private void validateCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private int validateTryCountType(String input){
        if(!input.matches(REGEXP)){
            throw new IllegalArgumentException(RaceValidatorException.NON_NUMERIC_TRY_COUNT.getMessage());
        }
        return Integer.parseInt(input);
    }



}
