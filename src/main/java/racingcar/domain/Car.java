package racingcar.domain;

public class Car {
    private final String carName;
    private int advanceCount = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void advanceCar() {
        this.advanceCount += 1;
    }

    public void printStatus(){
        System.out.print(carName+" : ");
        for (int i = 0; i < advanceCount; i++) {
            System.out.print("-");
        };
        System.out.println();
    }
}
