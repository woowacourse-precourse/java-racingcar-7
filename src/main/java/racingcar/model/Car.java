package racingcar.model;

public class Car {
    private final CarRacer carRacer;
    private int distance;

    public Car(CarRacer carRacer) {
        this.carRacer = carRacer;
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public CarRacer getCarRacer() {
        return this.carRacer;
    }

    public void decideToGo(int randomNumber) {
        if (canProceed(randomNumber)) {
            goOneStep();
        }
    }

    private void goOneStep() {
        this.distance += 1;
    }

    private boolean canProceed(int randomNumber) {
        return randomNumber > 4;
    }
}
