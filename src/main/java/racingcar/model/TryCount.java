package racingcar.model;

import racingcar.validator.TryCountValidator;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount, TryCountValidator tryCountValidator){
        tryCountValidator.validTryCount(tryCount);
        this.tryCount = tryCount;
    }

    public boolean isNotZero(){
        return this.tryCount != 0;
    }

    public void reduceTryCount(){
        this.tryCount--;
    }
}
