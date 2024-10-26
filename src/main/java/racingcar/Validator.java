package racingcar;


import java.util.List;

public class Validator {
    private static final int CAR_NAME_NIN_NAME= 1;
    private static final int CAR_NAME_MAX_NAME = 5;
    private static final String SPACE = "";
    private final Parser parser = new Parser();

    public void checkCarNamesInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        List<String> carNameList = parser.parseCarNames(input);
    }

    public void checkNumberOfTrialInput(String input) throws IllegalArgumentException {
        checkCharAndThrowException(input);
        checkEmptyAndThrowException(input);
    }

    private void checkCharAndThrowException(String input) {
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 시도할 횟수를 입력해주세요.");
        }
    }

    private void checkEmptyAndThrowException(String input){
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }
    
}
