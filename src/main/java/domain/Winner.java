package domain;

import java.util.List;

import static java.util.Comparator.comparingInt;

public class Winner {

    private final List<Car> cars;
    private String winner;

    public Winner(List<Car> cars) {
        this.cars = cars;
        findWinners();
    }

    public void findWinners() {

        StringBuilder sb = new StringBuilder();
        cars.sort(comparingInt(Car::getStatus).reversed());
        Car MaxStatusCar = cars.get(0);

        for(Car car: cars) {
            if(MaxStatusCar.getStatus() == car.getStatus()) {
                sb.append(car.getName() + " ");
            }
        }

        this.winner = sb.toString();
    }

    public String getWinner() {
        return winner;
    }
}
