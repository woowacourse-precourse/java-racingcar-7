package racingcar.domain;

//note attemptcounter get 해오지 말고 내부에서 차감
public class AttemptCounter {
    private final int attemptNumber;

    public AttemptCounter(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public boolean isEndAttempt(int numberOfAttempt) {
        return attemptNumber == numberOfAttempt;
    }

    //todo 시도 횟수 유효검사ㅣ

}
