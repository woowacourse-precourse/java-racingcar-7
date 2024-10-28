package racingcar.util;

public enum ExceptionMessage {
    CARNAGE_EXCEPTION("자동차의 이름을 다시 입력해주세요"),
    RACING_ATTEMPT_EXCEPTION("경주 횟수는 양의 정수로 입력해주세요");

    private final String exceptionMessage;

     ExceptionMessage(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage(){
        return exceptionMessage;
    }



}
