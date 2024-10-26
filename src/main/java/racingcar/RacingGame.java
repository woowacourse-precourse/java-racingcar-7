package racingcar;

public class RacingGame {
    Car car = new Car();
    Integer attemptNum;

    public void run(){
        car.set();
        setAttemptNum();
    }

    private void setAttemptNum(){
        String attemptNumInput = UserView.readAttemptNum();
        checkAttemptNumContext(attemptNumInput);
        attemptNum = Integer.parseInt(attemptNumInput);
        checkAttemptNumSize();
    }

    private void checkAttemptNumContext(String attemptNumInput){
        if (!attemptNumInput.matches("^[0-9]+$")){
            throwArgumentException("시도 횟수는 양의 정수만 입력 가능합니다.");
        }
    }

    private void checkAttemptNumSize(){
        if (1 > attemptNum || attemptNum > 10){
            throwArgumentException("시도 횟수는 1 이상, 10 이하로 입력해야 합니다.");
        }
    }

    private void throwArgumentException(String errorContext){
        throw new IllegalArgumentException(errorContext);
    }

}