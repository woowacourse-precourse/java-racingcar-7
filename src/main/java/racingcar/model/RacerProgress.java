package racingcar.model;

public class RacerProgress {
    private static final String OUTPUT_SEPARATOR = " : ";
    private static final String PROGRESS_INDICATOR = "-";
    private final String string;

    public RacerProgress(Car car) {
        string = car.getName() + OUTPUT_SEPARATOR + PROGRESS_INDICATOR.repeat(car.getProgress());
    }

    public String generateString() {
        return string;
    }
}
