package racingcar.car;

import racingcar.util.RandomValueProvider;

import static racingcar.constant.Condition.FORWARD_CONDITION;

public class ForwardMovementDecider {
    private final RandomValueProvider randomValueProvider = new RandomValueProvider();

    public boolean validateCondition() {
        return randomValueProvider.provideRandomValue() >= FORWARD_CONDITION.value();
    }

}
