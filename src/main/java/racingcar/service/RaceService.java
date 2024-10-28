package racingcar.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RoundResult;
import racingcar.model.Car;

public class RaceService {

    private List<Car> cars;

    public RaceService() {
    }

    private void save(List<String> carNameList) {
        this.cars = new ArrayList<>();
        for (String carName : carNameList) {
            this.cars.add(new Car(carName));
        }
    }

    public void roundStart() {
        for (Car car : this.cars) {
            car.moveOrStop();
        }
    }

    private void saveRound(List<Car> cars, List<RoundResult> roundResults) {
        RoundResult round = new RoundResult();
        for (Car car : cars) {
            round.carNames.add(car.getName());
            round.carPositions.add(car.getPosition());
        }
        roundResults.add(round);
    }

    public List<RoundResult> raceStart(int tryCount, List<String> carNameList) {
        save(carNameList);
        List<RoundResult> roundResults = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            roundStart();
            saveRound(this.cars, roundResults);
        }
        return roundResults;
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();

        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
