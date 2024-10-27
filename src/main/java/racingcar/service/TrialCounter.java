package racingcar.service;

/**
 * TrialCounter 클래스는 남은 시도 횟수를 관리한다.
 */
public class TrialCounter {

    private int count;   // 시도 횟수 저장 변수

    /**
     * 시도 횟수를 초기화한다.
     */
    public void initTrialCount(int count) {
        this.count = count;
    }

    /**
     * 시도 횟수가 모두 소진되었는지 여부를 반환한다.
     */
    public boolean isFinish() {
        return count == 0;
    }

    /**
     * 시도 횟수를 1회 감소시킨다.
     */
    public void takeTrial() {
        count--;
    }
}
