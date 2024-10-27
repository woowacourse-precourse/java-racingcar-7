package racingcar.domain.racer.movecondition;

public class Condition {

    private static final int FORWARD_THRESHOLD = 4;
    private final NumberGenerator generator;

    public Condition(NumberGenerator generator) {
        this.generator = generator;
    }

    public boolean canMoveForward() {
        return generator.generate() >= FORWARD_THRESHOLD;
    }

}
