package racingcar.move;

public class CarRaceMoveGenerator implements MoveGenerator {

    private final int startInclusive;
    private final int endInclusive;
    private final int aboveStandard;
    private final RandomNumberGenerator randomNumberGenerator;

    public CarRaceMoveGenerator(CarRaceMoveConfig config, RandomNumberGenerator randomNumberGenerator) {
        this.startInclusive = config.getStartInclusive();
        this.endInclusive = config.getEndInclusive();
        this.aboveStandard = config.getAboveStandard();
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean move() {
        int number = randomNumberGenerator.generate(startInclusive, endInclusive);
        return number >= aboveStandard;
    }
}
