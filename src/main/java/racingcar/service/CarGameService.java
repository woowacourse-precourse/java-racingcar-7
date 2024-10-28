package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public class CarGameService {
    public String playGames(List<Car> vehicles, int tryCount) {
        for (int i = 0; i <tryCount; i++) {
            for (Car car : vehicles) {
                car.move();
                car.printLocation();
            }
            System.out.println();
        }
        return findWinner(vehicles);
    }

    private String findWinner(List<Car> vehicles) {
        int max = vehicles.stream().mapToInt(Car::getLocation).max().orElse(0);
        List<String> winners = vehicles.stream()
                .filter(car -> car.getLocation() == max)
                .map(Car::getName)
                .toList();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < winners.size()-1; i++) {
            sb.append(winners.get(i));
            sb.append(", ");
        }
        sb.append(winners.get(winners.size()-1));
        return sb.toString();
    }
}
