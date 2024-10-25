package racingcar.validator;

public class TryCountValidiator {

    public void positiveNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
