package racingcar.view;

public class TestInputView implements InputInterface{

    private String[] carNames;
    private int tryCount;

    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    @Override
    public String[] getCarNames() {
        return carNames;
    }

    @Override
    public int getTryCount() {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return tryCount;
    }
}
