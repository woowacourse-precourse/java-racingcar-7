package racingcar.domain;

public class Car {

    private final String name;
    private int location;
    private int trialCount;

    public Car(String name, int trialCount) {
        this.name = name;
        this.location = 0;
        this.trialCount = trialCount;
    }

    public void forward() {
        validateTrialCount();
        this.location += 1;
        this.trialCount -= 1;
    }

    public void stop() {
        validateTrialCount();
        this.trialCount -= 1;
    }

    private void validateTrialCount() {
        if (this.trialCount == 0) {
            throw new IllegalArgumentException("이동 횟수가 끝난 자동차는 움직일 수 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }
}