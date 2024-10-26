package racingcar.race;

public class ThresholdMoveStrategy implements RaceMoveStrategy {
    private final NumberGenerator numberGenerator;
    private final int winningThreshold;

    public ThresholdMoveStrategy(NumberGenerator numberGenerator, int winningThreshold) {
        this.numberGenerator = numberGenerator;
        this.winningThreshold = winningThreshold;
    }

    @Override
    public boolean canMove() {
        int generatedNumber = numberGenerator.generate();
        return generatedNumber >= winningThreshold;
    }
}
