package racingcar.domain;

public class NumberOverFour implements Movement {

    public static final int MOVE_BOUNDARY_INCLUSIVE = 4;

    private final NumberGenerator numberGenerator;

    public NumberOverFour(NumberGenerator numberStrategy) {
        this.numberGenerator = numberStrategy;
    }

    @Override
    public boolean canMove() {
        return numberGenerator.generate() >= MOVE_BOUNDARY_INCLUSIVE;
    }
}
