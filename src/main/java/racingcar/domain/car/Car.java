package racingcar.domain.car;

import racingcar.domain.common.IncrementNumber;
import racingcar.domain.round.RoundResult;

public class Car {

    private final CarName name;
    private final Condition condition;
    private final IncrementNumber position;

    public Car(String name, Condition condition) {
        this.name = new CarName(name);
        this.condition = condition;
        this.position = new IncrementNumber();
    }

    public void forward() {
        if (condition.canMoveForward()) {
            this.position.increment();
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return this.name.value();
    }

    public RoundResult toRoundResult() {
        return RoundResult.from(this);
    }

}
