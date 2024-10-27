package racingcar.util;

public enum ExceptionMessage {

    INVALID_NOT_NATURAL_NUMBER("자연수만 입력 가능합니다."),
    INVALID_OUT_OF_INPUT_BOUND("입력 범위를 초과하였습니다."),
    INVALID_NUMBER_OF_CARS("자동차 경주 게임은 두 대 이상부터 게임 진행이 가능합니다."),
    INVALID_CAR_NAME_LENGTH("자동차의 이름은 5글자 이하만 가능합니다,");

    public static final String ERROR_MESSAGE_FORMAT="[ERROR %s]";
    public final String message;

    ExceptionMessage(String message){
        this.message =String.format(ERROR_MESSAGE_FORMAT,message);
    }

    public String getMessage(){
        return message;
    }
}
