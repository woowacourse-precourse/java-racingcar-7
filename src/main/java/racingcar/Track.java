package racingcar;

import java.util.ArrayList;

public class Track {
    private final ArrayList<Car> cars;

    public Track(ArrayList<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void print() {
        for (Car car : cars) {
            car.print();
        }
    }

    public ArrayList<Car> getWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
