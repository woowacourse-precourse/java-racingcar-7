package racingcar.util;

public enum ExceptionMessage {

    CARNAGE_EXCEPTION("자동차의 이름을 잘못 입력하셨습니다"),
    RACING_ATTEMPT_EXCEPTION("경주 횟수를 잘못 입력하셨습니다")
    ;

    private final String exceptionMessage;

     ExceptionMessage(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage(){
        return exceptionMessage;
    }



}
