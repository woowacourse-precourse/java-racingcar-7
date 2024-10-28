package racingcar.executor.decider.movement;

public class RandomMovementDeciderImpl implements RandomMovementDecider {

    @Override
    public boolean decide(int randomNumber) {
        return randomNumber >= 4;
    }
}
