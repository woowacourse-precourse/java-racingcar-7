package racingcar.view;

public class InputValidator {
    private static String EMPTY_VALUE_ERROR_MESSAGE = "모든 입력은 비어있을 수 없습니다.";
    public static void validateInput(String inputString){
        if(inputString.isBlank()){
            throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
        }
    }
}
