package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;

public class WinnerService {
    CarRepository carRepository;

    public WinnerService() {
        this.carRepository = new CarRepositoryImpl();
    }

    public void printWinners() {
        List<Car> winners = decisionWinners();

        String[] winnerArr = winners.stream()
                .map(Car::getName)
                .toArray(String[]::new);

        String winnersStr = String.join(", ", winnerArr);
        System.out.print("최종 우승자 : " + winnersStr);
    }

    private List<Car> decisionWinners() {
        int maxDistance = getMaxDistance();

        List<Car> carsResult = carRepository.findAll();
        List<Car> winners = carsResult.stream()
                .filter((car) -> car.getDistance() == maxDistance)
                .toList();

        return winners;
    }

    private int getMaxDistance() {
        List<Car> carsResult = carRepository.findAll();

        int maxDistance = carsResult.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElse(0);

        return maxDistance;
    }
}
