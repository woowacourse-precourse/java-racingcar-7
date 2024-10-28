package racingcar;

import java.util.function.Supplier;

public class Car {
    private final String carName;
    private int place;
    private final Supplier<Integer> pickUpLogic;

    public Car(String carName, Supplier<Integer> pickUpLogic) {
        if (carName.isEmpty() || carName.length() > 5) throw new IllegalArgumentException();
        this.carName = carName;
        this.place = 0;
        this.pickUpLogic = pickUpLogic;
    }

    public void move() {
        int pick = pickUpLogic.get();
        if (pick >= 4 && pick < 10) {
            place++;
        }
    }

    public void printPlace() {
        String positionMark = "-".repeat(place);
        System.out.println(carName + " : " + positionMark);
    }

    public String getCarName() {
        return carName;
    }

    public int getPlace() {
        return place;
    }
}
