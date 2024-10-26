package racingcar.model;

import racingcar.validator.TryCountValidator;

public class TryCount {
    private int tryCount;

    public TryCount(int tryCount, TryCountValidator tryCountValidator){
        tryCountValidator.validTryCount(tryCount);
        this.tryCount = tryCount;
    }

    public int getTryCount(){
        return this.tryCount;
    }
}
