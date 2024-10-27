package racingcar.domain.racer;

import racingcar.domain.common.IncrementNumber;
import racingcar.domain.racer.movecondition.Condition;
import racingcar.domain.racer.movecondition.NumberGenerator;
import racingcar.domain.round.RoundResult;

public class Racer {

    private final CarName name;
    private final Condition condition;
    private final IncrementNumber position;

    private Racer(String name, NumberGenerator numberGenerator) {
        this.name = CarName.from(name);
        this.condition = new Condition(numberGenerator);
        this.position = new IncrementNumber();
    }

    public static Racer of(String name, NumberGenerator numberGenerator) {
        return new Racer(name, numberGenerator);
    }

    public void forward() {
        if (this.condition.canMoveForward()) {
            this.position.increment();
        }
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public String getName() {
        return this.name.value();
    }

    public RoundResult toRoundResult() {
        return RoundResult.from(this);
    }

}
