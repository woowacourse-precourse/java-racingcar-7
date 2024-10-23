package racingcar.validator;

public interface Validator {
    int convertTryCountToInt(String stringTryCount);
    void validTryCount(int tryCount);
}
