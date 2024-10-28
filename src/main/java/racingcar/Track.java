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

    public void printWinners() {
        ArrayList<Car> winners = getWinners();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
