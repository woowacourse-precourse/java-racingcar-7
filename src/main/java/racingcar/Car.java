package racingcar;

public class Car {
    private int forwardNumber = 0;
    private final String carName;

    private Car(String carName) {
        this.carName = carName;
    }

    public void movingForward() {
        this.forwardNumber++;
        printMovingResult(this.forwardNumber);
    }

    public void stop() {
        printMovingResult(this.forwardNumber);
    }

    static public Car create(String carName) {
        return new Car(carName);
    }

    private void printMovingResult(int forwardNumber) {
        System.out.print(carName + " : ");
        for (int i = 1; i <= forwardNumber; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
