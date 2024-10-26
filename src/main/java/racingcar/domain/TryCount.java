package racingcar.domain;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount) {
        tryCountValidate(tryCount);
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void tryCountValidate(int tryCount) {
        if(tryCount <= 0){
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 작을 수 없습니다");
        }
    }
}
