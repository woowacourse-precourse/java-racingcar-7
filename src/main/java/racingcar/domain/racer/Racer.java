package racingcar.domain.racer;

import racingcar.domain.common.IncrementNumber;
import racingcar.domain.racer.utils.Condition;
import racingcar.domain.racer.utils.NumberGenerator;
import racingcar.domain.round.RoundResult;

public class Racer {

    private final CarName name;
    private final Condition condition;
    private final IncrementNumber position;

    public Racer(String name, Condition condition) {
        this.name = new CarName(name);
        this.condition = condition;
        this.position = new IncrementNumber();
    }

    public static Racer of(String name, NumberGenerator numberGenerator) {
        return new Racer(name, new Condition(numberGenerator));
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
