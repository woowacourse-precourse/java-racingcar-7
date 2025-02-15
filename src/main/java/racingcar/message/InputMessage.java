package racingcar.message;

public enum InputMessage implements MessageManager{
    INPUT_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_COUNT("시도할 횟수는 몇 회인가요?"),

    ;

    private final String message;

    InputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
