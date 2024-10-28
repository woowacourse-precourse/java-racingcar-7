package racingcar;

public class Car {
    private String carname;
    private int dashes;

    public Car(String carname) {
        this.carname = carname;
        this.dashes = 0;
    }

    public void moveForward() {
        dashes++;
    }

    public String getName() {
        return carname;
    }

    public int getPosition() {
        return dashes;
    }

    public static void printCarPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
