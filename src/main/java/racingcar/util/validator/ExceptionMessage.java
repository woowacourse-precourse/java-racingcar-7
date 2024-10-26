package racingcar.util.validator;

public enum ExceptionMessage {

    INVALID_NOT_NATURAL_NUMBER("자연수만 입력 가능합니다.");

    public static final String BASE_ERROR_MESSAGE="[ERROR %s]";
    public final String message;

    ExceptionMessage(String message){
        this.message =String.format(BASE_ERROR_MESSAGE,message);
    }

    public String getMessage(){
        return message;
    }
}
