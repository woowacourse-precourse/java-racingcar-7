package domain;

import java.util.List;

public class Winner {

    private static final StringBuilder sb = new StringBuilder();

    private final List<Car> cars;
    private String winner;

    public Winner(List<Car> cars) {
        this.cars = cars;
        findWinners();
    }

    public void findWinners() {
        int maxStatus = findMaxStatus();

        for(Car car: cars) {
            if(maxStatus == car.getStatus()) {
                sb.append(car.getName());
                sb.append(" ");
            }
        }

        this.winner = sb.toString();
    }

    private int findMaxStatus() {
        return cars.stream()
                .mapToInt(Car::getStatus)
                .max().getAsInt();
    }

    public String getWinner() {
        return winner;
    }
}
