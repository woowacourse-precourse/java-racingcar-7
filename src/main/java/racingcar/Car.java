package racingcar;

public class Car {
    private int forwardNumber = 0;
    private String carName;

    public void movingForward() {
        this.forwardNumber++;
        printMovingResult(this.forwardNumber);
    }

    public void stop() {
        printMovingResult(this.forwardNumber);
    }

    private void printMovingResult(int forwardNumber) {
        System.out.print(carName + " : ");
        for (int i = 1; i <= forwardNumber; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
