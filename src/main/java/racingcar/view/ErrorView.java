package racingcar.view;

public class ErrorView {
    private static final String RACINGCAR_DUPLICATE_NAME_ERROR_MESSAGE = "[ERROR] 레이싱 자동차 이름은 중복될 수 없습니다.";
    private static final String RACINGCAR_BLANK_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름에 공백을 입력할 수 없습니다.";
    private static final String RACINGCAR_LENGTH_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름의 길이는 5자 이하만 가능합니다.";
    
    public static void printRacingcarDuplicateNameErrorMessage(){
        System.out.println(RACINGCAR_DUPLICATE_NAME_ERROR_MESSAGE);
    }

    public static void printRacingcarBlankNameErrorMessage(){
        System.out.println(RACINGCAR_BLANK_NAME_ERROR_MESSAGE);
    }

    public static void printRacingcarLengthErrorMessage(){
        System.out.println(RACINGCAR_LENGTH_NAME_ERROR_MESSAGE);
    }
}
