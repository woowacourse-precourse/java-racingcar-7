package racingcar.service;

public class AcceleratorService {
    private static final int MOVEMENT_THRESHOLD = 4;
    private final NumberGenerator numberGenerator;

    public AcceleratorService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canMoveForward() {
        int randomNumber = numberGenerator.generateNumber();
        return randomNumber >= MOVEMENT_THRESHOLD;
    }
}