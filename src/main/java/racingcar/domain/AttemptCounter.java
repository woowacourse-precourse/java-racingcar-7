package racingcar.domain;

//note attemptcounter get 해오지 말고 내부에서 차감
public class AttemptCounter {
    private int attemptNumber;

    public AttemptCounter(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public boolean isEndAttempt() {
        return attemptNumber <= 0;
    }

    public void decrease() {
        this.attemptNumber--;
    }

    //todo 시도 횟수 유효검사ㅣ

}
