package racingcar.model;

public class RandomDriveStrategy implements DriveStrategy {

    public static final int ADVANCE_THRESHOLD = 3;
    private final NumberGenerator numberGenerator;

    public RandomDriveStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int drive(int position) {
        int randomNumber = numberGenerator.generate();

        if (randomNumber > ADVANCE_THRESHOLD) {
            return position + 1;
        }
        return position;
    }
}
